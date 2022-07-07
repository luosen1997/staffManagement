package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.model.Dept;

public interface DeptDao {

	public int getDeptListCount(Dept dept);

	public List<Dept> getDeptListByPage(@Param("dept")Dept dept, @Param("start")Integer start, @Param("limit")Integer limit);
	
	public int addDept(Dept dept);

	public Dept getDeptById(Integer id);

	public int updateDept(Dept dept);

	public int deleteDept(@Param("ids")String ids);
	
	List<Dept> findAllDept();
}
