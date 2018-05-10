package com.example.jwtdemo.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean  {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        //将servletReuest和ServletResponse改为HttpServletRequest和HttpServletResponse
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;

        // 获取http请求授权
        final String authHeader = request.getHeader("authorization");

        // 如果Http请求是选项，那么只需返回状态码200
        // 这是HttpServletResponse。SC_OK在这段代码中
        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);
        }
        //除选项外，其他请求应该由JWT检查
        else {

            // 检查授权，检查令牌是否由“持有者”启动
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("无效的或缺少授权");
            }

            // 然后从授权获取JWT令牌
            final String token = authHeader.substring(7);

            try {
                // 使用JWT解析器检查签名是否有效，使用密钥“secretkey”
                final Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();

                //将请求添加到请求头
                request.setAttribute("claims", claims);
            } catch (final SignatureException e) {
                throw new ServletException("无效的token");
            }

            chain.doFilter(req, res);
        }
    }
}
