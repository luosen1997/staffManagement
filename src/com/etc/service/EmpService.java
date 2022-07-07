package com.etc.service;

import java.util.List;

import com.etc.model.Emp;

public interface EmpService {

	public int getEmpListCount(Emp emp);

	public List<Emp> getEmpListByPage(Emp emp, Integer page, Integer limit);
	
	public boolean addEmp(Emp emp);

	public Emp getEmpById(Integer id);

	public boolean updateEmp(Emp emp);

	public boolean deleteEmp(String ids);
}
