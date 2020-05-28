package com.etoak.execption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


import lombok.extern.slf4j.Slf4j;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Et1911LoginException.class)
	public ModelAndView handLoginException(Et1911LoginException e) {
		String msg=e.getMessage();
		log.error(msg,e);//日志打印   异常信息：12123123121211
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("error",msg);
		mv.setViewName("login");
		return mv;
	}
	
	
	
	
	
	
	
	
	@ExceptionHandler(ParamException.class)
	public ModelAndView handleParamException(ParamException e) {
		
		String message = e.getMessage();
		
		log.error(message,e);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("paramError",message);
		
		mv.setViewName("car/add");
		
		return mv;
	}
}
