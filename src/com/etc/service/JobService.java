package com.etc.service;

import java.util.List;

import com.etc.model.Job;

public interface JobService {

	public int getJobListCount(Job job);

	public List<Job> getJobListByPage(Job job, Integer page, Integer limit);
	
	public boolean addJob(Job job);

	public Job getJobById(Integer id);

	public boolean updateJob(Job job);

	public boolean deleteJob(String ids);

	//下拉菜单，查询全部职位方法
	public List<Job> findAllJob();
}
