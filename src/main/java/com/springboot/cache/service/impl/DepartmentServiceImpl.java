package com.springboot.cache.service.impl;

import com.springboot.cache.model.entity.Department;
import com.springboot.cache.model.mapper.DepartmentMapper;
import com.springboot.cache.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/3/4.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getEntityById(Integer id) {
        return departmentMapper.entityById(id);
    }
}
