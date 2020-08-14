package com.etoak.config;

import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class ActiveMqConfig {
	@Bean
	public ActiveMQConnectionFactory mqFactory() {
		ActiveMQConnectionFactory factory =
				new ActiveMQConnectionFactory(
						null,null,"tcp://localhost:61616");
		
		factory.setUseAsyncSend(true);
		return factory;
	}

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory factory=new
				CachingConnectionFactory(this.mqFactory());
		
		factory.setSessionCacheSize(20);
		return factory;
	}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate =new JmsTemplate();
		jmsTemplate.setConnectionFactory(this.connectionFactory());
		
		//服务质量
		jmsTemplate.setExplicitQosEnabled(true);
		jmsTemplate.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		//客户端签收
		jmsTemplate.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE);
		
		return jmsTemplate;
	}
}
