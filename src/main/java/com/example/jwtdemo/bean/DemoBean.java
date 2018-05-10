package com.example.jwtdemo.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class DemoBean {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String password ;
}
