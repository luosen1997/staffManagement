package com.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.NotDao;
import com.etc.model.Not;
import com.etc.service.NotService;

@Service
public class NotServiceImpl implements NotService{

	@Autowired
	private NotDao notDao;
	
	@Override
	public int getNotListCount(Not not) {
		
		return notDao.getNotListCount(not);
	}

	@Override
	public List<Not> getNotListByPage(Not not, Integer page, Integer limit) {
		Integer start = (page-1)*limit;
		return notDao.getNotListByPage(not,start,limit);
	}
	
	@Override
	@Transactional
	public boolean addNot(Not not) {
//		not.setPassword(MD5Util.md5Encode(not.getPassword()));
		if(notDao.addNot(not)>0){
			return true;
		}
		return false;
	}

	@Override
	public Not getNotById(Integer id) {
		return notDao.getNotById(id);
	}

	@Override
	@Transactional
	public boolean updateNot(Not not) {
		if(notDao.updateNot(not)>0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteNot(String ids) {
		if(notDao.deleteNot(ids)>0){
			return true;
		}
		return false;
	}
	
}
