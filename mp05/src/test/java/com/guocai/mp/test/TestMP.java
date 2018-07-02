package com.guocai.mp.test;

import com.guocai.mp.entity.Employee;
import com.guocai.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * java类简单作用描述
 *
 * @ClassName: TestMP
 * @Package: com.guocai.mp.mp
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/2 8:55
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestMP {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmployeeMapper employeeMapper = ac.getBean("employeeMapper",EmployeeMapper.class);

	/**
	 * @Description: 测试公共字段填充
	 * @auther: Sun Guocai
	 * @date:   2018/7/2 10:15
	 * @name:   testMetaObjectHandler
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testMetaObjectHandler(){
		Employee emp = new Employee();
		emp.setVersion(1);
		emp.setEmail("boduo@guocai.com");
		emp.setLastName("苍老师");
		emp.setAge(36);
		emp.setGender("2");
		emp.insert();
	}

	@Test
	public void testUpdateMetaObjecthandler(){
		Employee emp = new Employee();
		emp.setVersion(2);
		emp.setId(12);

		employeeMapper.updateById(emp);
	}


	/**
	 * @Description: 测试逻辑删除
	 * @auther: Sun Guocai
	 * @date:   2018/7/2 9:44
	 * @name:   testLogicDelete
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testLogicDelete(){
		employeeMapper.deleteById(13);
	}


	@Test
	public void testMySqlInjector(){
		//employeeMapper.deleteAll();
	}

}
