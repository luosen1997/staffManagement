package com.etc.service;

import java.util.List;

import com.etc.model.Dept;

public interface DeptService {

	public int getDeptListCount(Dept dept);

	public List<Dept> getDeptListByPage(Dept dept, Integer page, Integer limit);
	
	public boolean addDept(Dept dept);

	/**
	 * 根据id查询部门信息
	 * @param id 查询参数
	 * @return 部门对象
	 */
	public Dept getDeptById(Integer id);

	/**
	 * 部门修改操作
	 * @param user
	 * @return
	 */
	public boolean updateDept(Dept dept);

	public boolean deleteDept(String ids);
	
	//下拉菜单，查询全部部门方法
	public List<Dept> findAllDept();
	
}
