package com.guocai.mp.test;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.guocai.mp.entity.Employee;
import com.guocai.mp.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * java类简单作用描述
 *
 * @ClassName: TestMP
 * @Package: com.guocai.mp.test
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/27 14:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestMP {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	EmployeeMapper employeeMapper = ac.getBean("employeeMapper", EmployeeMapper.class);
	/**
	 * @Description: 测试条件构造器Wrapper
	 * @auther: Sun Guocai
	 * @date:   2018/6/28 10:09
	 * @name:   testEntityWrapper
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testEntityWrapper(){


		List<Employee> employees = employeeMapper.selectList(new EntityWrapper<Employee>()
				.orderDesc(Arrays.asList("age"))
		);
		for (Employee employee : employees) {
			System.out.println("employee--->" + employee);
		}

		/*employeeMapper.delete(new EntityWrapper<Employee>()
				.between("age",35,40)
				.and()
				.eq("gender",0)

		);*/

		/*Employee employee = new Employee();
		employee.setAge(37);
		employee.setGender(0);
		Integer update = employeeMapper.update(employee, new EntityWrapper<Employee>()
				.like("last_name", "James")
				.and()
				.eq("age", 52)

		);
		System.out.println(update);*/

		/*List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 3), new EntityWrapper<Employee>()
				.between("age", 20, 50)
				.like("last_name", "James")
				.and()
				.eq("gender", 1)
		);
		for (Employee employee : employees) {
			System.out.println("employee--->" + employee);
		}*/


		/*List<Employee> employees = employeeMapper.selectPage(new Page<Employee>(1, 2), new EntityWrapper<Employee>()
				.eq("gender", 0)
				.like("email", "l")
				.or()
				.eq("last_name", "James")

		);
		for (Employee employee : employees) {
			System.out.println("employee--->" + employee);
		}*/
	}




	/**
	 * @Description: 测试deleteBatchIds方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 16:58
	 * @name:   testDeleteBatchIds
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testDeleteBatchIds(){
		List<Integer> list = Arrays.asList(-4, -3, -2, -1);
		employeeMapper.deleteBatchIds(list);
	}

	/**
	 * @Description: 测试deleteByMap方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 16:52
	 * @name:   testDeleteByMap
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testDeleteByMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id",-5);
		Integer t = employeeMapper.deleteByMap(map);
		System.out.println(t);
	}

	/**
	 * @Description: 测试deleteById方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 16:46
	 * @name:   testDeleteById
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testDeleteById(){
		Integer i = employeeMapper.deleteById(4);
		System.out.println(i);
	}


	/**
	 * @Description: 测试selectPage方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 16:42
	 * @name:   testSelectPage
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testSelectPage(){
		List<Employee> employees = employeeMapper.selectPage(new Page(2, 2), null);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	/**
	 * @Description: 测试selectByMap方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 16:35
	 * @name:   testSelectByMap
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testSelectByMap(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("last_Name","孙国财");
		List<Employee> employees = employeeMapper.selectByMap(map);
		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}

	/**
	 * @Description: selectBatchIds方法的测试
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 16:06
	 * @name:   testSelectBatchIds
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testSelectBatchIds(){
		List<Integer> list = Arrays.asList(1, 3, 5, 6);
		List<Employee> employees = employeeMapper.selectBatchIds(list);
		for (Employee employee : employees) {
			System.out.println(employee);
		}

	}


	/**
	 * @Description: 测试selectOne方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 16:01
	 * @name:   testSelectOne
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testSelectOne(){
		Employee emp = new Employee();
		emp.setAge(32);
		Employee employee = employeeMapper.selectOne(emp);
		System.out.println(employee);
	}

	/**
	 * @Description: 测试selectById方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 15:58
	 * @name:   testSelectById
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testSelectById(){
		Employee employee = employeeMapper.selectById(5);
		System.out.println(employee);
	}

	/**
	 * @Description: 更新所有的列，不管你设不设置值
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 15:55
	 * @name:   testUpdateAllColumnById
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testUpdateAllColumnById(){
		Employee emp = new Employee();
		emp.setLastName("孙国财");
		emp.setGender(1);
		emp.setAge(32);
		emp.setEmail("923055433@qq.com");
		emp.setId(6);
		Integer num = employeeMapper.updateAllColumnById(emp);
		System.out.println(num);
	}


	/**
	 * @Description: 更新所设置的字段
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 15:54
	 * @name:   testUpdateById
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testUpdateById(){
		Employee emp = new Employee();
		emp.setLastName("孙国财");
		emp.setGender(1);
		emp.setAge(32);
		emp.setEmail("923055433@qq.com");
		emp.setId(5);
		Integer num = employeeMapper.updateById(emp);
		System.out.println(num);
	}


	/**
	 * @Description: 测试insertAllColumn方法，所有字段全部进行插入，没有设置值的为空插入
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 15:38
	 * @name:   testInsert
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testInsert(){
		Employee emp = new Employee();
		emp.setLastName("孙鑫磊");
		//emp.setGender(0);
		//emp.setAge(2);
		emp.setEmail("yuhan@qq.com");
		Integer count = employeeMapper.insertAllColumn(emp);
		System.out.println(emp.getId());
	}

	/**
	 * @Description: 测试insert方法
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 15:38
	 * @name:   InsertEmpTest
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void InsertEmpTest(){
		Employee emp = new Employee();
		emp.setLastName("孙煜涵");
		emp.setGender(0);
		emp.setAge(2);
		emp.setEmail("yuhan@qq.com");
		Integer count = employeeMapper.insert(emp);
		System.out.println("------------>"+emp.getId());
	}

	/**
	 * @Description: 测试所有配置是否成功
	 * @auther: Sun Guocai
	 * @date:   2018/6/27 15:38
	 * @name:   testDataSource
	 * @param:  []
	 * @return: void
	 *
	 */
	@Test
	public void testDataSource(){
		DataSource dataSource = ac.getBean("dataSource", DataSource.class);
		System.out.println(dataSource);
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			System.out.println(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testJDBCConnectionMySQL(){
		/*
		 通过JDBC查询数据库数据，一般需要以下七个步骤：
			（1）  加载JDBC驱动

			（2）  建立并获取数据库连接

			（3）  创建 JDBC Statements 对象

			（4）  设置SQL语句的传入参数

			（5）  执行SQL语句并获得查询结果

			（6）  对查询结果进行转换处理并将处理结果返回

			（7）  释放相关资源（关闭Connection，关闭Statement，关闭ResultSet）
		*/
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatisplus", "root", "123456");
			System.out.println(conn);
			String sql = "select id,last_name,age,gender from tbl_employee where last_name = ? and id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,"孙国财");
			ps.setInt(2,5);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

}






















