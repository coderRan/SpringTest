package com.zdr.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdr.dao.baseDao.UserDao;
import com.zdr.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}
	
}
