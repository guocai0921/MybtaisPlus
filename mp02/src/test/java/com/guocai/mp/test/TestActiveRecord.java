package com.guocai.mp.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.guocai.mp.entity.Employee;
import com.guocai.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.management.NotificationEmitter;
import java.util.List;

/**
 * java类简单作用描述
 *
 * @ClassName: TestActiveRecord
 * @Package: com.guocai.mp.test
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/28 13:22
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestActiveRecord {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testARPage(){
		Employee emp = new Employee();
		Page<Employee> employeePage = emp.selectPage(new Page<Employee>(1, 3),
				new EntityWrapper<Employee>().like("last_name", "James"));
		List<Employee> records = employeePage.getRecords();
		for (Employee record : records) {
			System.out.println("record--->" + record);
		}
	}

	@Test
	public void testDelete(){
		Employee emp = new Employee();
		boolean b = emp.delete(new EntityWrapper().like("last_name", "James"));
		System.out.println("b = " + b);
	}
	
	@Test
	public void testARDeleteById(){
		Employee emp = new Employee();
		boolean b = emp.deleteById(23);
		System.out.println("b = " + b);
	}
	
	
	@Test
	public void testSelectCount(){
		Employee emp = new Employee();
		int i = emp.selectCount(new EntityWrapper().like("last_name", "James"));
		System.out.println("i = " + i);
	}
	
	@Test
	public void testSelectList(){
		Employee emp = new Employee();
		List<Employee> employees = emp.selectList(new EntityWrapper().between("age", 18, 50)
				.and()
				.like("last_name", "James")
		);
		for (Employee employee : employees) {
			System.out.println("employee--->" + employee);
		}
	}
	

	@Test
	public void testSelectById(){
		Employee emp = new Employee();
		Employee employee = emp.selectById(5);
		System.out.println("employee = " + employee);

	}


	@Test
	public void testSelect(){
		Employee emp = new Employee();
		List<Employee> employees = emp.selectAll();
		for (Employee employee : employees) {
			System.out.println("employee--->" + employee);
		}
	} 
	

	@Test
	public void testUpdate(){
		Employee emp = new Employee();
		emp.setAge(67);
		emp.setId(12);
		boolean b = emp.updateById();
		System.out.println(b);
	}


	@Test
	public void testARInsert(){
		Employee emp = new Employee();
		emp.setLastName("孙玉军");
		emp.setAge(65);
		emp.setGender(1);
		emp.setEmail("yujun@guocai.com");

		boolean b = emp.insert();
		System.out.println(b);
	}

}
