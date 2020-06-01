package com.etoak;

import com.etoak.service.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

public class JdkWsServer {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/hello",
                new HelloServiceImpl());
        System.out.println("Server start");
    }
}
