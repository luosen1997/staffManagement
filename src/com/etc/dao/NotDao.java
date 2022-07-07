package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.model.Not;

public interface NotDao {

	public int getNotListCount(Not not);

	public List<Not> getNotListByPage(@Param("notice")Not not, @Param("start")Integer start, @Param("limit")Integer limit);

	public int addNot(Not not);

	public Not getNotById(Integer id);

	public int updateNot(Not not);

	public int deleteNot(@Param("ids")String ids);
	
}
