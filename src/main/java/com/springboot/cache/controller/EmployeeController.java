package com.springboot.cache.controller;


import com.springboot.cache.model.entity.Department;
import com.springboot.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/2/14.
 */
@RestController
@RequestMapping("/ee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/entity/{id}")
    public Department getEmp(@PathVariable("id") Integer id){
      return   employeeService.getEmp(id);
    }
}
