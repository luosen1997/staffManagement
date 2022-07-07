package com.etc.service;

import java.util.List;

import com.etc.model.Not;

public interface NotService {

	public int getNotListCount(Not not);

	public List<Not> getNotListByPage(Not not, Integer page, Integer limit);
	
	public boolean addNot(Not not);

	public Not getNotById(Integer id);

	public boolean updateNot(Not not);

	public boolean deleteNot(String ids);
	
}
