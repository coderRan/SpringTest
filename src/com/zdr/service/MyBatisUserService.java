package com.zdr.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.zdr.dao.baseDao.UserDao;
import com.zdr.entity.User;
import com.zdr.utils.SqlSessionFactoryUtil;

public class MyBatisUserService {

	public List<User> findUsersByMybatis(){
		SqlSession session= SqlSessionFactoryUtil.openSession();
		UserDao userDao = session.getMapper(UserDao.class);
		List<User> list= userDao.findAllUsers();
		for(User u :list){
			System.out.println(u.toString());
		}
		return list;
	}
	
}
