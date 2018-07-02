package com.guocai.mp.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * java类简单作用描述
 *
 * @ClassName: MySqlInjector
 * @Package: com.guocai.mp.injector
 * @Description: < 自定义全局操作 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/2 8:58
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class MySqlInjector extends AutoSqlInjector {
	@Override
	public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
		//将EmployeeMapper中定义的deleteAll，处理成对应的MappedStatement对象，加入到Configuration中
		//注入SQL语句
		String sql = "delete from " + table.getTableName();
		//注入方法名，一定要有EmployeeMapper中定义的方法一致
		String method = "delteAll";

		//构造sqlSource对象
		SqlSource sqlSource = languageDriver.createSqlSource(configuration,sql,modelClass);

		//构造一个删除的MappedStatement
		this.addDeleteMappedStatement(mapperClass,method,sqlSource);
	}
}
