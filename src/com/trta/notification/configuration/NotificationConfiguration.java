package com.trta.notification.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.trta.notification.constants.NotificationConstants;

@Configuration
public class NotificationConfiguration {
/*
	private static Connection connection;
	private static Channel channel;
	
	public NotificationConfiguration(){
		setUp();
	}
	
	public Connection getConnection(){
		if(NotificationConfiguration.connection!=null) return NotificationConfiguration.connection;
		else{
			setUp();
			return NotificationConfiguration.connection;
		}
	}
	
	public Channel getChannel(){
		if(NotificationConfiguration.channel!=null) return NotificationConfiguration.channel;
		else{
			setUp();
			return NotificationConfiguration.channel;
		}
	}
	
	private void setUp(){
		try{
			 ConnectionFactory factory = new ConnectionFactory();
			    factory.setHost("localhost");
			    connection = factory.newConnection();
			    channel = connection.createChannel();
			    channel.queueDeclare(NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE, false, false, false, null);
			    channel.queueDeclare(NotificationConstants.ECP_REGISTRAR_TO_ECP_ETL_QUEUE, false, false, false, null);
			    channel.exchangeDeclare(NotificationConstants.XCHANGE,NotificationConstants.EXCHNAGE_MODE);
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
}
