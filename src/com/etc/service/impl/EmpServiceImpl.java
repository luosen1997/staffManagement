package com.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.EmpDao;
import com.etc.model.Emp;
import com.etc.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDao;
	
	@Override
	public int getEmpListCount(Emp emp) {
		
		return empDao.getEmpListCount(emp);
	}

	@Override
	public List<Emp> getEmpListByPage(Emp emp, Integer page, Integer limit) {
		Integer start = (page-1)*limit;
		return empDao.getEmpListByPage(emp,start,limit);
	}
	
	@Override
	@Transactional
	public boolean addEmp(Emp emp) {
		if(empDao.addEmp(emp)>0){
			return true;
		}
		return false;
	}

	@Override
	public Emp getEmpById(Integer id) {
		return empDao.getEmpById(id);
	}

	@Override
	@Transactional
	public boolean updateEmp(Emp emp) {
		if(empDao.updateEmp(emp)>0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteEmp(String ids) {
		if(empDao.deleteEmp(ids)>0){
			return true;
		}
		return false;
	}

}
