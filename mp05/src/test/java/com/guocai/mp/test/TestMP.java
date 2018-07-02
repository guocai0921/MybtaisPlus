package com.guocai.mp.test;

import com.guocai.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * java类简单作用描述
 *
 * @ClassName: TestMP
 * @Package: com.guocai.mp.test
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/2 8:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestMP {

	ApplicationContext ac = new ClassPathXmlApplicationContext("");
	EmployeeMapper employeeMapper = ac.getBean("employeeMapper",EmployeeMapper.class);

	@Test
	public void testMySqlInjector(){
		employeeMapper.deleteAll();
	}

}
