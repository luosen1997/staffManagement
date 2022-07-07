package com.etc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etc.model.Job;

public interface JobDao {

	public int getJobListCount(Job job);

	public List<Job> getJobListByPage(@Param("job")Job job, @Param("start")Integer start, @Param("limit")Integer limit);
	
	public int addJob(Job job);

	public Job getJobById(Integer id);

	public int updateJob(Job job);

	public int deleteJob(@Param("ids")String ids);

	public List<Job> findAllJob();
}
