package com.etoak.service.impl;

import com.etoak.bean.User;
import com.etoak.service.Uservice;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@WebService
@Service
public class UserviceImpl implements Uservice {


    @Override
    public User getById(int id) {
        return new User(id,"et1911",20);
    }
}
