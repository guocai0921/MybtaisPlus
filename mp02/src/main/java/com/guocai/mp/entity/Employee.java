package com.guocai.mp.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * java类简单作用描述
 *
 * @ClassName: Employee
 * @Package: com.guocai.mp.entity
 * @Description: < >
 * @Author: Sun GuoCai
 * @CreateDate: 2018/6/28 11:43
 * @UpdateRemark: The modified content
 * @Version: 1.0
 */
public class Employee extends Model<Employee>{

	private static final long serialVersionUID = 7787634727978416415L;
	private Integer id ;
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

	/**
	 * @Description: 指定当前这个类中的主键属性
	 * @auther: Sun Guocai
	 * @date:   2018/6/28 13:16
	 * @name:   pkVal
	 * @param:  []
	 * @return: java.io.Serializable
	 *
	 */
	protected Serializable pkVal() {
		return id;
	}
}
