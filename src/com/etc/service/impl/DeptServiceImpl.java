package com.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.DeptDao;
import com.etc.model.Dept;
import com.etc.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

	@Autowired
	private DeptDao deptDao;
	
	@Override
	public int getDeptListCount(Dept dept) {
		
		return deptDao.getDeptListCount(dept);
	}

	@Override
	public List<Dept> getDeptListByPage(Dept dept, Integer page, Integer limit) {
		Integer start = (page-1)*limit;
		return deptDao.getDeptListByPage(dept,start,limit);
	}
	
	@Override
	@Transactional
	public boolean addDept(Dept dept) {
		if(deptDao.addDept(dept)>0){
			return true;
		}
		return false;
	}

	@Override
	public Dept getDeptById(Integer id) {
		return deptDao.getDeptById(id);
	}

	@Override
	@Transactional
	public boolean updateDept(Dept dept) {
		if(deptDao.updateDept(dept)>0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteDept(String ids) {
		if(deptDao.deleteDept(ids)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Dept> findAllDept() {
		return deptDao.findAllDept();
	}
	
}
