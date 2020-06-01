package com.etoak.service;

import javax.jws.WebService;

//接口以及实现类+@WebService
@WebService
public interface HelloService {

    String sayHello(String name);

}
