package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.model.Emp;

public interface EmpDao {

	public int getEmpListCount(Emp emp);

	public List<Emp> getEmpListByPage(@Param("emp")Emp emp, @Param("start")Integer start, @Param("limit")Integer limit);
	
	public int addEmp(Emp emp);

	public Emp getEmpById(Integer id);

	public int updateEmp(Emp emp);

	public int deleteEmp(@Param("ids")String ids);
	
}
