package com.guocai.mp.test;

import com.baomidou.mybatisplus.plugins.Page;
import com.guocai.mp.entity.Employee;
import com.guocai.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * java类简单作用描述
 *
 * @ClassName: TestMP
 * @Package: com.guocai.mp.test
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/29 15:04
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestMP {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	EmployeeMapper employeeMapper = ac.getBean("employeeMapper",EmployeeMapper.class);

	@Test
	public void testSelectPage(){
		//List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(2, 3), null);
		//for (Employee employee : employees) {
		//	System.out.println("employee--->" + employee);
		//}

		Page<Employee> page = new Page<Employee>(2,3);
		List<Employee> employees = employeeMapper.selectPage(page, null);
		for (Employee employee : employees) {
			System.out.println("employee--->" + employee);
		}

		System.out.println("总条数:"+page.getTotal());
		System.out.println("当前页码:"+page.getCurrent());
		System.out.println("总页码:"+page.getPages());
		System.out.println("每页显示的条数:"+page.getSize());
		System.out.println("是否显示上一页:"+page.hasPrevious());
		System.out.println("是否显示下一页:"+page.hasNext());

		//将查询的结果封装到Page对象中
		page.setRecords(employees);

	}

}
