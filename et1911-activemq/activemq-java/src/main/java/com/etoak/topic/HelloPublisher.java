package com.etoak.topic;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloPublisher {

	public static void main(String[] args) throws JMSException {
		ConnectionFactory factory =new ActiveMQConnectionFactory(null,null,"tcp://localhost:61616");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Topic topic = session.createTopic("Topic");
		
		MessageProducer producer = session.createProducer(topic);
		
		MapMessage msg = session.createMapMessage();
		msg.setString("name", "topic msg");
		msg.setInt("id", 1);
		
		producer.send(msg);
		
		producer.close();
		session.close();
		connection.close();
		
	}

}
