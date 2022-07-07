package com.etc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.etc.dao.JobDao;
import com.etc.model.Job;
import com.etc.service.JobService;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	private JobDao jobDao;

	@Override
	public int getJobListCount(Job job) {
		
		return jobDao.getJobListCount(job);
		
	}

	@Override
	public List<Job> getJobListByPage(Job job, Integer page, Integer limit) {
		Integer start = (page-1)*limit;
		return jobDao.getJobListByPage(job,start,limit);
	}
	
	@Override
	@Transactional
	public boolean addJob(Job job) {
//		job.setPassword(MD5Util.md5Encode(job.getPassword()));
		if(jobDao.addJob(job)>0){
			return true;
		}
		return false;
	}

	@Override
	public Job getJobById(Integer id) {
		return jobDao.getJobById(id);
	}

	@Override
	@Transactional
	public boolean updateJob(Job job) {
		if(jobDao.updateJob(job)>0){
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean deleteJob(String ids) {
		if(jobDao.deleteJob(ids)>0){
			return true;
		}
		return false;
	}

	@Override
	public List<Job> findAllJob() {
		return jobDao.findAllJob();
	}

}
