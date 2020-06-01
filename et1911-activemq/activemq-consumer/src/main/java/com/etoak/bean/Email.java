package com.etoak.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

	//收件人      发件人    主题     内容     附件.抄送
	private String receiver;
	
	//private String sender;
	
	private String subject;
	
	private String  content;
}
