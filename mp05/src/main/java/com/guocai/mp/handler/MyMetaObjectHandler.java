package com.guocai.mp.handler;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * java类简单作用描述
 *
 * @ClassName: MetaObjectHandler
 * @Package: com.guocai.mp.handler
 * @Description: < 自定义公共字段填充处理器 >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/7/2 10:06
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class MyMetaObjectHandler extends MetaObjectHandler{
	public void insertFill(MetaObject metaObject) {
		//获取到需要被填充的字段的值
		Object time = getFieldValByName("updateTime", metaObject);
		if(time ==null){
			System.out.println("********* 插入操作 满足填充条件 *********");
			setFieldValByName("updateTime",new Date(),metaObject);
		}
	}

	public void updateFill(MetaObject metaObject) {
		Object time = getFieldValByName("updateTime", metaObject);
		if(time ==null){
			System.out.println("********* 更新操作 满足填充条件 *********");
			setFieldValByName("updateTime",new Date(),metaObject);
		}
	}
}
