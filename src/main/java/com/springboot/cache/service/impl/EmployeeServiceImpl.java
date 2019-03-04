package com.springboot.cache.service.impl;


import com.springboot.cache.model.entity.Department;
import com.springboot.cache.model.mapper.DepartmentMapper;
import com.springboot.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/2/14.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    //将方法的运行结果放到缓存中
    @Cacheable
    public Department getEmp(Integer id) {
        return departmentMapper.entityById(id);
    }
}
