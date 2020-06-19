package com.etoak.service.impl;

import com.etoak.service.MobileCodeWSSoap;

import javax.jws.WebService;

@WebService
public class MobileCodeWSSoapImpl implements MobileCodeWSSoap {
    @Override
    public String getMobileCodeInfo(String phone) {
        return phone;
    }
}
