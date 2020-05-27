package com.etoak.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.User;
import com.etoak.mapper.UserMapper;
import com.etoak.service.Uservice;
@Service
public class UserServiceImpl implements Uservice {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User getById(int id) {
		
		return userMapper.getById(id);
	}

	@Override
	public User getByNameAndPassword(String name, String password) {
		
		return userMapper.getByNameAndPassword(name,password);
	}

}
