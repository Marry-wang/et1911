package com.etoak;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.etoak.action.UserAction;

public class XmlTest {

	public static void main(String[] args) {
		ApplicationContext ioc =
		new ClassPathXmlApplicationContext("Spring.xml");
		
		 UserAction userAction = ioc.getBean(UserAction.class);
		 
		 System.out.println(userAction);
		 System.out.println(userAction.getById(100));
		 
	}
}
