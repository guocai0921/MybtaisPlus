package com.guocai.mp.test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * java类简单作用描述
 *
 * @ClassName: TestMP
 * @Package: com.guocai.mp.test
 * @Description: <  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/28 14:29
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class TestMP {

	@Test
	public void testGenerator(){
		//全局配置
		GlobalConfig globalConfig = new GlobalConfig();
		globalConfig.setActiveRecord(true)  //是否支持AR模式
				.setAuthor("Sun GuoCai")  //设置作者
				.setOutputDir("D:\\idea\\IdeaProjects\\mp\\mp03\\src\\main\\java")  //设置文件生成的路径
				.setFileOverride(true)  //设置文件多次生成是否覆盖
				.setIdType(IdType.AUTO)  //设置主键的生成策略
				.setServiceName("%sService") //设置生成的Service接口的名字首字母是否带I
				.setBaseResultMap(true)  //设置是否生成ResultMap
				.setBaseColumnList(true); //设置是否生成SQL片段

		//数据源配置
		DataSourceConfig dataSourceConfig = new DataSourceConfig();
		dataSourceConfig.setDbType(DbType.MYSQL)
				.setDriverName("com.mysql.jdbc.Driver")
				.setUrl("jdbc:mysql://localhost:3306/mybatisplus")
				.setUsername("root")
				.setPassword("123456");

		//策略配置
		StrategyConfig strategyConfig = new StrategyConfig();
		strategyConfig.setCapitalMode(true)  //全局大写命名
				.setDbColumnUnderline(true)  //指定表名 字段名是否使用下划线
				.setNaming(NamingStrategy.underline_to_camel)  //数据据映射到实体类的命名策略
				.setTablePrefix("tbl_")  //表前缀
				.setInclude("tbl_employee");  //要生成数据库的表
		// 排除生成的表
		//strategy.setInclude(INCLUD_TABLE.split(",")); // 需要生成的表
		// 自定义实体父类
		//strategy.setSuperEntityClass("com.sgai.sadp.core.base.entity.AbstractEntity");
		// 自定义实体，公共字段
		//strategy.setSuperEntityColumns(new String[] { "SID", "VERSION" });
		// 自定义 mapper 父类
		//strategy.setSuperMapperClass("com.sgai.sadp.core.base.mapper.BaseMapper");
		// 自定义 service 父类
		//strategy.setSuperServiceClass("com.sgai.sadp.core.base.service.BaseService");
		// 自定义 service 实现类父类
		//strategy.setSuperServiceImplClass("com.sgai.sadp.core.base.service.BaseCRUDService");
		// 自定义 controller 父类
		//strategy.setSuperControllerClass("com.sgai.sadp.core.base.controller.BaseController");
		// 生成 RestController 风格
		//strategy.setRestControllerStyle(true);



		//包名策略配置
		PackageConfig packageConfig = new PackageConfig();
		packageConfig.setParent("com.guocai.mp")
				.setController("controller")
				.setService("service")
				.setEntity("entity")
				.setMapper("mapper")
				.setServiceImpl("service.impl")
				.setXml("mapper");

		//整合配置
		AutoGenerator autoGenerator = new AutoGenerator();
		autoGenerator.setGlobalConfig(globalConfig)
				.setDataSource(dataSourceConfig)
				.setStrategy(strategyConfig)
				.setPackageInfo(packageConfig);

		// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
		// 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
		TemplateConfig templateConfig = new TemplateConfig();
		templateConfig.setController("/templates/controller.java.vm");
		templateConfig.setEntity("/templates/entity.java.vm");
		templateConfig.setMapper("/templates/mapper.java.vm");
		templateConfig.setXml("/templates/mapper.xml.vm");
		templateConfig.setService("/templates/service.java.vm");
		templateConfig.setServiceImpl("/templates/serviceImpl.java.vm");
		// 如上任何一个模块如果设置 空 OR Null 将不生成该模块。

		//执行
		autoGenerator.execute();
	}

}
