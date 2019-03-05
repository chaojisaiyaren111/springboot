package com.springboot.cache.model.mapper;


import com.springboot.cache.model.entity.Employee;
import org.apache.ibatis.annotations.Param;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/2/14.
 */
public interface EmployeeMapper {
    Employee entityById(Integer id);

    Employee updateEmployee(Employee employee);

    void deleteEmp(Integer id);

    Employee getByLastName(@Param("lastName") String lastName);
}
