package com.etoak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[]args) {
		new ClassPathXmlApplicationContext("spring-activemq.xml");
	}
}