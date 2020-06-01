package com.etoak;

import com.etoak.service.HelloService;
import com.etoak.service.impl.HelloServiceImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class CXFServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory =new JaxWsServerFactoryBean();

        factory.setAddress("http://localhost:8080/hello");

        factory.setServiceClass(HelloService.class);

        factory.setServiceBean(new HelloServiceImpl());

        Server server =factory.create();
        server.start();
        System.out.println("Server start");
    }
}
