package com.example.jwtdemo.Service;


import com.example.jwtdemo.DAO.DemoDao;
import com.example.jwtdemo.bean.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
    @Autowired
    DemoDao demoDao;


    public Page find(Pageable pageable){
        return demoDao.findAll(pageable);
    }
    public DemoBean add(DemoBean demoBean){
        return demoDao.saveAndFlush(demoBean);
    }
}
