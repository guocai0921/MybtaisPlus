package com.guocai.mp.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.guocai.mp.entity.Employee;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Sun GuoCai
 * @since 2018-06-28
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
	int deleteAll();
}
