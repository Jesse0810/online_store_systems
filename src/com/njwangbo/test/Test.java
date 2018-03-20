package com.njwangbo.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.njwangbo.pojo.User;
import com.njwangbo.service.UserService;


public class Test {
	public static void main(String[] args) {
		Test.sqlSessionFactory();
	}
	
	public static void sqlSessionFactory() {
//		ApplicationContext cxt = new ClassPathXmlApplicationContext("spring.xml");
////		SqlSessionFactory factory = (SqlSessionFactory) cxt.getBean("sqlSessionFactory");
//		
//		UserService userService = (UserService) cxt.getBean("userService");
//		User user = new User();
//		user.setName("jesasdasdsda5");
//		user.setPwd("1234asasdasddas5");
//		user.setLvl(0);
//		user.setSex(0);
//		user.setImage("user4.jpg");
//		user.setTel("");
//		int count = userService.insertUser(user);
		
		
		
//		int count = userService.deleteUserById(user);
		System.out.println(System.getProperty("user.dir")+"\\WebRoot\\");
		
	}
	
}
