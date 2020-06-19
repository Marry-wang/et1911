package com.etoak;

import com.etoak.service.User;
import com.etoak.service.Uservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringClient {
    public static void main(String[] args) {
        ApplicationContext ios=new ClassPathXmlApplicationContext("spring-cxf.xml");
        Uservice uservice=(Uservice)ios.getBean("uservice");
        User user=uservice.getById(100);
        System.out.print(user.getName()+":"+user.getAge());
    }
}
