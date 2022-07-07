package com.etc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.model.Job;
import com.etc.service.JobService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/job")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping("/getJobList")
	@ResponseBody
	public Map<String,Object> getJobList(Integer page,Integer limit,String searchParams) throws Exception{
		Map<String,Object> map = new HashMap<>();
		
		Job job = new Job();//查询条件
		if(searchParams !=null){
			job  = objectMapper.readValue(searchParams, Job.class);
		}
		
		//查询总的数据条数
		int count = jobService.getJobListCount(job);
		
		//分页查询出用户列表
		List<Job> jobList = jobService.getJobListByPage(job,page,limit);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", jobList);
		
		return map;
	}
	
	@RequestMapping("/jobAdd")
	@ResponseBody
	public Map<String,Object> jobAdd(Job job){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(jobService.addJob(job)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		
		return map;
	}
	
	@RequestMapping("/showJob")
	public String getJobById(Integer id,Model model){
		
		Job job = jobService.getJobById(id);
		model.addAttribute("job", job);
		return "job/job-edit";
	}
	
	
	@RequestMapping("/jobUpdate")
	@ResponseBody
	public Map<String,Object> jobUpdate(Job job){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(jobService.updateJob(job)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
	
	@RequestMapping("/jobDelete")
	@ResponseBody
	public Map<String,Object> jobUpdate(String ids){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(jobService.deleteJob(ids)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
}
