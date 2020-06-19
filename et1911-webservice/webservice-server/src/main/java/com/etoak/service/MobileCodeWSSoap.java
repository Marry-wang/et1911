package com.etoak.service;

import javax.jws.WebService;

@WebService
public interface MobileCodeWSSoap {
    String getMobileCodeInfo(String phone);
}
