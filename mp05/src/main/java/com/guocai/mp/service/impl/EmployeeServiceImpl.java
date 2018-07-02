package com.guocai.mp.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.guocai.mp.entity.Employee;
import com.guocai.mp.mapper.EmployeeMapper;
import com.guocai.mp.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Sun GuoCai
 * @since 2018-06-28
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
