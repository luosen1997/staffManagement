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
import com.etc.model.Emp;
import com.etc.model.Job;
import com.etc.service.DeptService;
import com.etc.service.EmpService;
import com.etc.service.JobService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	@Autowired
	private JobService jobService;
	@Autowired
	private DeptService deptService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
    @RequestMapping("/empListShow")
    public String getEmpListShow(Model model){
        List<Job> jobs = jobService.findAllJob();
        List<Dept> depts = deptService.findAllDept();
        
//        System.out.println(depts);
        
        model.addAttribute("jobs",jobs);
        model.addAttribute("depts",depts);
        return "emp/emp-list";
    }

    @RequestMapping("/empListShowAdd")
    public String getEmpListShowAdd(Model model){
        List<Job> jobs = jobService.findAllJob();
        List<Dept> depts=deptService.findAllDept();
        model.addAttribute("jobs",jobs);
        model.addAttribute("depts",depts);
        return "emp/emp-add";
    }
	
	@RequestMapping("/getEmpList")
	@ResponseBody
	public Map<String,Object> getEmpList(Integer page,Integer limit,String searchParams) throws Exception{
		Map<String,Object> map = new HashMap<>();
		
		Emp emp = new Emp();//查询条件
		if(searchParams !=null){
			emp = objectMapper.readValue(searchParams, Emp.class);
		}
		
		//查询总的数据条数
		int count = empService.getEmpListCount(emp);
		
		//分页查询出用户列表
		List<Emp> empList = empService.getEmpListByPage(emp,page,limit);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", empList);
		
		return map;
	}
	
	@RequestMapping("/empAdd")
	@ResponseBody
	public Map<String,Object> empAdd(Emp emp){
		Map<String,Object> map = new HashMap<>();
		
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(empService.addEmp(emp)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		
		System.out.println(map);
		return map;
	}
	
	@RequestMapping("/showEmp")
	public String getEmpById(Integer id,Model model){
		Emp emp = empService.getEmpById(id);
		model.addAttribute("emp", emp);
		
    	List<Job> jobs = jobService.findAllJob();
        List<Dept> depts=deptService.findAllDept();
        model.addAttribute("jobs",jobs);
        model.addAttribute("depts",depts);
		return "emp/emp-edit";
	}
	
	
	@RequestMapping("/empUpdate")
	@ResponseBody
	public Map<String,Object> empUpdate(Emp emp){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(empService.updateEmp(emp)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
	@RequestMapping("/empDelete")
	@ResponseBody
	public Map<String,Object> empUpdate(String ids){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(empService.deleteEmp(ids)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
}
