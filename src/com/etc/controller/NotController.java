package com.etc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.model.Not;
import com.etc.service.NotService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/not")
public class NotController {

	@Autowired
	private NotService notService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping("/getNotList")
	@ResponseBody
	public Map<String,Object> getNotList(Integer page,Integer limit,String searchParams) throws Exception{
		Map<String,Object> map = new HashMap<>();
		
		Not not = new Not();//查询条件
		if(searchParams !=null){
			not = objectMapper.readValue(searchParams, Not.class);
		}
		
		//查询总的数据条数
		int count = notService.getNotListCount(not);
		
		//分页查询出用户列表
		List<Not> notList = notService.getNotListByPage(not,page,limit);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", notList);
		
		return map;
	}
	
	@RequestMapping("/notAdd")
	@ResponseBody
	public Map<String,Object> notAdd(Not not){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(notService.addNot(not)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		
		return map;
	}
	
	@RequestMapping("/showNot")
	public String getNotById(Integer id,Model model){
		
		Not notice = notService.getNotById(id);
		model.addAttribute("notice", notice);
		return "not/not-edit";
	}
	
	
	@RequestMapping("/notUpdate")
	@ResponseBody
	public Map<String,Object> notUpdate(Not not){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(notService.updateNot(not)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
	
	@RequestMapping("/notDelete")
	@ResponseBody
	public Map<String,Object> notUpdate(String ids){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(notService.deleteNot(ids)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
}
