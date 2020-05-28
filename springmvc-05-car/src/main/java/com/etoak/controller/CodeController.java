package com.etoak.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.VerifyCode;

@Controller
public class CodeController {

	@RequestMapping("/code")
	public void code(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//创建验证码对象  
		VerifyCode code =new VerifyCode();
		BufferedImage image =code.createImage();
		request.getSession().setAttribute("code", code.getResult()+"");
		
		
		//向前端写图片
		response.setHeader("Pragma", "no-cache");//禁止缓存
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expries", 0);
		response.setContentType("image/jpeg");
		ImageIO.write(image,"JPEG",response.getOutputStream())	;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
