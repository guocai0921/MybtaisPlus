package com.guocai.mp.entity;

import com.baomidou.mybatisplus.annotations.TableField;

/**
 * java类简单作用描述
 *
 * @ClassName: Employee
 * @Package: com.guocai.mp.entity
 * @Description: < 定义JavaBean时成员变量所使用的类型
 *       因为每个基本类型都对应一个默认值
 *       Integer--->int   0
 *       Boolean--->boolean   false
 *
 *  >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/27 13:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
//@TableName(value = "tbl_employee")
public class Employee {

	//@TableId(value = "id",type = IdType.AUTO)
	private Integer id ;

	//@TableField(value = "last_name")
	private String lastName;
	private String email ;
	private Integer gender ;
	private Integer age ;

	@TableField(exist = false)
	private Double salary;

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", gender=" + gender +
				", age=" + age +
				'}';
	}
}
