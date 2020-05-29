package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProducer {

	public static void main(String[] args) throws JMSException {
		//connectionfactory  
		ConnectionFactory factory =new ActiveMQConnectionFactory(null,null,
				"tcp://localhost:61616");
		
		Connection connection=factory.createConnection();
		connection.start();
		
		Session session =connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Queue helloQueue =session.createQueue("hello2");
		
		MessageProducer producer=session.createProducer(helloQueue);
		
		TextMessage msg = session.createTextMessage("123123123");
		
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();
		System.out.println("5555555");
	}

}
