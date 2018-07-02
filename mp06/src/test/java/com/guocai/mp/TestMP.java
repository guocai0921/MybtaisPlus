package com.guocai.mp;

import com.guocai.mp.entity.User;
import com.guocai.mp.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * java类简单作用描述
 *
 * @ClassName: TestMp
 * @Package: com.guocai.mp.mp
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/2 14:00
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestMP {

	ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	UserMapper userMapper = ac.getBean("userMapper",UserMapper.class);

	@Test
	public void testOracle(){
		User user = new User();
		user.setName("詹姆斯");
		user.setLogicFlag(1);
		Integer insert = userMapper.insert(user);
		System.out.println("insert = " + insert);
	}

	@Test
	public void getDatasource(){
		javax.sql.DataSource dataSource = ac.getBean("dataSource", javax.sql.DataSource.class);
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

}
