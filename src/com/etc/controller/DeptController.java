package com.etc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.model.Dept;
import com.etc.service.DeptService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/dept")
public class DeptController {

	
	@Autowired
	private DeptService deptService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping("/getDeptList")
	@ResponseBody
	public Map<String,Object> getDeptList(Integer page,Integer limit,String searchParams) throws Exception{
		Map<String,Object> map = new HashMap<>();
		
		Dept dept = new Dept();//查询条件
		if(searchParams !=null){
			dept = objectMapper.readValue(searchParams, Dept.class);
		}
		
		//查询总的数据条数
		int count = deptService.getDeptListCount(dept);
		
		//分页查询出用户列表
		List<Dept> deptList = deptService.getDeptListByPage(dept,page,limit);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", deptList);
		
		return map;
	}
	
	@RequestMapping("/deptAdd")
	@ResponseBody
	public Map<String,Object> deptAdd(Dept dept){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(deptService.addDept(dept)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		
		return map;
	}
	
	@RequestMapping("/showDept")
	public String getDeptById(Integer id,Model model){
		
		Dept dept = deptService.getDeptById(id);
		model.addAttribute("dept", dept);
		return "dept/dept-edit";
	}
	
	
	@RequestMapping("/deptUpdate")
	@ResponseBody
	public Map<String,Object> deptUpdate(Dept dept){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(deptService.updateDept(dept)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
	
	@RequestMapping("/deptDelete")
	@ResponseBody
	public Map<String,Object> deptUpdate(String ids){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(deptService.deleteDept(ids)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
}
