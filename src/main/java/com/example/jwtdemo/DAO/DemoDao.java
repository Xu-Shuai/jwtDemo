package com.example.jwtdemo.DAO;


import com.example.jwtdemo.bean.DemoBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoDao extends JpaRepository<DemoBean,Long> {

}
