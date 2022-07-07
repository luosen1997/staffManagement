package com.etc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.model.User;
import com.etc.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/user")
//@SessionAttributes("sess_user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping("/login")
	@ResponseBody
	public String login(String loginname,String password,HttpSession session){
		
		User user = userService.getUser(loginname,password);
		if(user != null){
			session.setAttribute("sess_user", user);
			return "success";
		}
		
		return "error";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();//注销当前会话
		
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public Map<String,Object> getUserList(Integer page,Integer limit,String searchParams) throws Exception{
		Map<String,Object> map = new HashMap<>();
		
		User user = new User();//查询条件
		if(searchParams !=null){
			user = objectMapper.readValue(searchParams, User.class);
		}
		
		//查询总的数据条数
		int count = userService.getUserListCount(user);
		
		//分页查询出用户列表
		List<User> userList = userService.getUserListByPage(user,page,limit);
		
		map.put("code", 0);
		map.put("msg", "");
		map.put("count", count);
		map.put("data", userList);
		
		return map;
	}
	
	@RequestMapping("/userAdd")
	@ResponseBody
	public Map<String,Object> userAdd(User user){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(userService.addUser(user)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		
		return map;
	}
	
	@RequestMapping("/showUser")
	public String getUserById(Integer id,Model model){
		
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "user/user-edit";
	}
	
	
	@RequestMapping("/userUpdate")
	@ResponseBody
	public Map<String,Object> userUpdate(User user){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(userService.updateUser(user)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}
	
	
	@RequestMapping("/userDelete")
	@ResponseBody
	public Map<String,Object> userUpdate(String ids){
		Map<String,Object> map = new HashMap<>();
		map.put("code", "1002");
		map.put("msg", "error");
		
		if(userService.deleteUser(ids)){
			map.put("code", "1001");
			map.put("msg", "success");
		}
		return map;
	}

}
