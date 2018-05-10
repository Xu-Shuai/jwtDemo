package com.example.jwtdemo.controller;


import com.example.jwtdemo.Service.DemoService;
import com.example.jwtdemo.bean.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@CrossOrigin
public class demoController {
    @Autowired
    DemoService service;
    @GetMapping("/find")
    public Page<DemoBean> find(Pageable pageable){
        return service.find(pageable);
    }
    @PostMapping("/")
    public DemoBean add(@RequestBody DemoBean demoBean){
        return service.add(demoBean);
    }
}
