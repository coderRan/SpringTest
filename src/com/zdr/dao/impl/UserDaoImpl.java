package com.zdr.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.zdr.dao.BaseDao;
import com.zdr.dao.baseDao.UserDao;
import com.zdr.entity.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public List<User> findAllUsers() {
		String query = "select * from users";
		List<User> uList = new ArrayList<User>();
		ResultSet rs = this.executeQuery(query, null);
		try {
			
			while(rs.next()){
				String account = rs.getString("account");
				String pwd = rs.getString("pwd");
				User newUser = new User(account,pwd);
				uList.add(newUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return uList;
	}

	

}
