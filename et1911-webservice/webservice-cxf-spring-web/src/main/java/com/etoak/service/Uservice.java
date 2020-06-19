package com.etoak.service;

import com.etoak.bean.User;

import javax.jws.WebService;

@WebService
public interface Uservice {
    User getById(int id);
}
