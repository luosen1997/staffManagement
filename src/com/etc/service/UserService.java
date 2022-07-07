package com.etc.service;

import java.util.List;

import com.etc.model.User;

public interface UserService {

	public User getUser(String loginname, String password);

	public int getUserListCount(User user);

	public List<User> getUserListByPage(User user, Integer page, Integer limit);

	public boolean addUser(User user);

	/**
	 * 根据id查询用户信息
	 * @param id 查询参数
	 * @return 用户对象
	 */
	public User getUserById(Integer id);

	/**
	 * 用户修改操作
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user);

	public boolean deleteUser(String ids);

}
