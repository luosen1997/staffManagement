package com.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.UserDao;
import com.etc.model.User;
import com.etc.service.UserService;
import com.etc.util.MD5Util;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly=true)
	public User getUser(String loginname, String password) {
		password = MD5Util.md5Encode(password);
		return userDao.getUser(loginname,password);
	}

	@Override
	public int getUserListCount(User user) {
		
		return userDao.getUserListCount(user);
	}

	@Override
	public List<User> getUserListByPage(User user, Integer page, Integer limit) {
		Integer start = (page-1)*limit;
		return userDao.getUserListByPage(user,start,limit);
	}

	@Override
	@Transactional
	public boolean addUser(User user) {
		user.setPassword(MD5Util.md5Encode(user.getPassword()));
		if(userDao.addUser(user)>0){
			return true;
		}
		return false;
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.getUserById(id);
	}

	@Override
	@Transactional
	public boolean updateUser(User user) {
		if(userDao.updateUser(user)>0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteUser(String ids) {
		if(userDao.deleteUser(ids)>0){
			return true;
		}
		return false;
	}

}
