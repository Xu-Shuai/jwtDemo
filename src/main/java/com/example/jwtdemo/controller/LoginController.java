package com.example.jwtdemo.controller;



import com.example.jwtdemo.bean.DemoBean;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/loginCon")
public class LoginController {


    @PostMapping("/")
    public String login(@RequestBody()DemoBean demoBean)  {
        String jwtToken = Jwts.builder().setSubject(demoBean.getUserName()).claim("roles", "member").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        return jwtToken;
    }
}
