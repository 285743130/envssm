package com.pb.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.pb.domain.User;
import com.pb.service.UserService;

@Controller
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	UserService userService;
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/loginOut.do", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	@RequestMapping(value = "/updateuser.do", method = RequestMethod.POST)
	public String updateUser(HttpSession session,Model model,String nickName,Integer age,String gender,String phoneNumber,String address) {
		User user = (User) session.getAttribute("user");
		user.setNickName(nickName);
		user.setAge(age);
		user.setGender(gender);
		user.setPhoneNumber(phoneNumber);
		user.setAddress(address);
		userService.UpdateUser(user);
		return "redirect:index.jsp";
	}
	
	@RequestMapping(value = "/checkUser.do", method = RequestMethod.POST)
	public String checkUser(String name ,String password,Model model,HttpSession session) {
		boolean flag = userService.userIsExists(name, password);
		if(flag){
			User user = userService.findByName(name);
			session.setAttribute("user", user);
			return "index";
		}else{
			String message = "用户名或密码错误！";
			model.addAttribute("message", message);
			return "login";
		}
		
	}
	
	@RequestMapping(value = "/updateusersimple.do", method = RequestMethod.POST)
	public String userInfo(String name,String password) {
		User user = userService.findByName(name);
		user.setPassword(password);
		userService.UpdateUser(user);
		
		return "userinfosingle";
	}
	
	@RequestMapping(value = "/manageuserInfo.do", method = RequestMethod.GET)
	public String manageUserInfo(Model model) {
		List<User> list = userService.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/displayuserinfo";
	}
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	public String addUserInfo(String name ,String nickName,Integer age,String gender,String phoneNumber,String address,String password){
		User user = new User();
		user.setName(name);
		user.setNickName(nickName);
		user.setAge(age);
		user.setGender(gender);
		user.setPhoneNumber(phoneNumber);
		user.setPassword(password);
		user.setAddress(address);
		user.setPermission(0);
		userService.addUser(user);;
		return "redirect:manageuserInfo.do";
		
	}
	
	
	
}
