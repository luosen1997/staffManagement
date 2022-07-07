package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.model.User;

public interface UserDao {

	public User getUser(@Param("loginname")String loginname, @Param("password")String password);

	public int getUserListCount(User user);

	public List<User> getUserListByPage(@Param("user")User user, @Param("start")Integer start, @Param("limit")Integer limit);

	public int addUser(User user);

	public User getUserById(Integer id);

	public int updateUser(User user);

	public int deleteUser(@Param("ids")String ids);

}
