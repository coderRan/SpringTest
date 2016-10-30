package com.zdr.dao.baseDao;

import java.util.List;
import com.zdr.entity.User;

public interface UserDao {
	public List<User> findAllUsers();
}

