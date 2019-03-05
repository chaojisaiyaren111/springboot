package com.springboot.cache.service.impl;


import com.springboot.cache.model.entity.Employee;
import com.springboot.cache.model.mapper.EmployeeMapper;
import com.springboot.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/2/14.
 * 全局缓存
 */
@Service
//@CacheConfig(cacheNames = "emp")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    //将方法的运行结果放到缓存中
    //cacheNames 将返回的结果放到哪个缓存中
    //key 默认是方法的参数值
    //condition 在什么场景下缓存 #参数名称 或者#a0,,第一个参数
    @Cacheable(value = "emp", key = "'emp_'+#id")
    public Employee getEmp(Integer id) {
        return employeeMapper.entityById(id);
    }

    /**
     * 更新数据库后同步更新缓存
     *
     * @param employee
     */
    @Override
    @CachePut(value = "emp", key = "'emp_'+#employee.id")
    //同步更新时必须要有返回值,key的id为返回值的id
    public Employee updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
        return employee;
    }

    /**
     * 删除数据,同时删除缓存
     */
    @Override
    @CacheEvict(value = "emp", key = "'emp_'+#id")
    public void deleteEmp(Integer id) {
        employeeMapper.deleteEmp(id);
    }

    /**
     * 组合缓存
     * 必须有返回值
     */
    @Override
    @Caching(
            cacheable = {
                    @Cacheable(value = "emp", key = "#lastName")
            },
            //同时将lastName,id都缓存
            put = {
                    @CachePut(value = "emp", key = "#result.lastName"),
                    @CachePut(value = "emp", key = "#result.id"),
            }
    )
    public Employee getByLastName(String lastName) {
        return employeeMapper.getByLastName(lastName);
    }


}
