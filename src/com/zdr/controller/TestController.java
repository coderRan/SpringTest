package com.zdr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdr.entity.User;

import com.zdr.service.MyBatisUserService;
import com.zdr.service.UserService;

@Controller
public class TestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public String gotoIndex(){
		return "/index";
	}
	//返回json数据
	@RequestMapping(value = "/json")
	@ResponseBody
	public User getJSON(){
		return new User("test","123456");
	}
	
	//使用Spring 管理
	@RequestMapping(value = "/getAllUsers")
	@ResponseBody
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	//使用Spring 管理
	@RequestMapping(value = "/getUsers")
	@ResponseBody
	public List<User> getUsers(){
		MyBatisUserService myService = new MyBatisUserService();
		return myService.findUsersByMybatis();
	}
	
}
