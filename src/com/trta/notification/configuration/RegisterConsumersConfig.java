package com.trta.notification.configuration;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.AMQP.Connection;
import com.rabbitmq.client.Channel;
import com.trta.notification.constants.NotificationConstants;

//@EnableRabbit
//@Configuration
public class RegisterConsumersConfig {

	private org.springframework.amqp.rabbit.connection.Connection connection;
	
	public Channel channel;
	   // @Autowired
	    private ConnectionFactory connectionFactory;

	    //@Bean
	    public AmqpAdmin amqpAdmin() {
	
	        return new RabbitAdmin(this.connectionFactory);
	    }

	  //  @Bean
	    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
	        final SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
	        factory.setConnectionFactory(this.connectionFactory);
	       // factory.setMessageConverter(messageConverter());
	        factory.setConcurrentConsumers(3);
	        factory.setMaxConcurrentConsumers(10);
	        return factory;
	    }

	  //  @Bean
	    public RabbitTemplate rabbitTemplate() {
	    	try{
	        final RabbitTemplate template = new RabbitTemplate(this.connectionFactory);
	      //  template.setMessageConverter(messageConverter());
	        this.connection=template.getConnectionFactory().createConnection();
	        Channel channel=this.connection.createChannel(false);
	        this.channel.exchangeDeclare(NotificationConstants.XCHANGE, NotificationConstants.EXCHNAGE_MODE);
	        this.channel.queueDeclare(NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE, false, false, false, null);
	        this.channel.queueBind(NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE,NotificationConstants.XCHANGE,null);
	        return template;
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return null;
	    }

	   // @Bean
	    public Channel channel(){
	    	try{
	    	RabbitTemplate template=rabbitTemplate();
	    	this.connection=template.getConnectionFactory().createConnection();
	    	System.out.println("This.conn "+this.connection.isOpen());
	        Channel channel=this.connection.createChannel(false);
	        channel.exchangeDeclare(NotificationConstants.XCHANGE, NotificationConstants.EXCHNAGE_MODE);
	        channel.queueDeclare(NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE, false, false, false, null);
	        channel.queueBind(NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE,NotificationConstants.XCHANGE,null);
	        return channel;
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	return null;
	    }

}
