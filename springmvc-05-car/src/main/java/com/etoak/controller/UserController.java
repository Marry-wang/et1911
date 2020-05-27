package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;
import com.etoak.execption.Et1911LoginException;
import com.etoak.service.Uservice;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	Uservice userService;
	
	@GetMapping("/getById")
	@ResponseBody
	public User getById(int id) {
		return userService.getById(id);
	}
	
	@GetMapping("/logout")
	
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		//重定向
		return "redirect:/user/toLogin";
	}
	
	@PostMapping("/login")
	public String login(
			@RequestParam String name,
			@RequestParam String password,
			@RequestParam String code,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Object sessionCode = (String)session.getAttribute("code");
		if(!code.equals(sessionCode)) {
			throw new Et1911LoginException("验证码不正确");
		}
		
		password=DigestUtils.md5Hex(password);
		User user = userService.getByNameAndPassword(name, password);
		if(ObjectUtils.isEmpty(user)) {
			throw new Et1911LoginException("用户名或密码不正确");
		}
		
		//将用户密码 null 重新获取
		session.invalidate();
		session=request.getSession();
		user.setPassword(null);
		session.setAttribute("user",user);
		
		return "redirect:/";
	}
	
	
	
	
	
	
}
