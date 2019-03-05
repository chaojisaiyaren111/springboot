package com.springboot.cache.controller;


import com.springboot.cache.model.entity.Employee;
import com.springboot.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/entity/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        return employeeService.getEmp(id);
    }

    @RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
    public Employee updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return employee;
    }

    @RequestMapping(value = "/deleteEmp", method = RequestMethod.POST)
    public void deleteEmp(Integer id) {
        employeeService.deleteEmp(id);
    }

    @RequestMapping(value = "getBylastName", method = RequestMethod.POST)
    public Employee getByLastName(String lastName) {
        return employeeService.getByLastName(lastName);
    }
}
