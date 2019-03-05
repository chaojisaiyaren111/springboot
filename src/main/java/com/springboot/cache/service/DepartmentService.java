package com.springboot.cache.service;

import com.springboot.cache.model.entity.Department;

/**
 * 西安海汇防务科技有限公司
 * Copyright (c) 2018, tianta All Rights Reserved.
 * Created by xiejiayi on 2019/3/4.
 */
public interface DepartmentService {
    Department getEntityById(Integer id);
}
