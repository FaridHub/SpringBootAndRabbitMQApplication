package com.trta.notification.configuration;

import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerAnnotationBeanPostProcessor;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;

import com.trta.notification.constants.NotificationConstants;





//@Configuration
//@EnableRabbit
public class RabbitConfiguration {

	/*
	@Autowired
	CachingConnectionFactory cachingConnectionFactory;
	@Autowired
	SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory;
	/*
	@Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(rabbitConnectionFactory());
        container.setQueueNames(NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE);
        container.setMessageListener(exampleListener());
        return container;
    }

    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory =
            new CachingConnectionFactory("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    public MessageListener exampleListener() {
        return (new MessageListener( ){
			@Override
			@RabbitListener(bindings = @QueueBinding(
			        value = @Queue(value = com.trta.notification.constants.NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE),
			        exchange = @Exchange(value = NotificationConstants.XCHANGE, type=NotificationConstants.EXCHNAGE_MODE))
			)
			public void onMessage(Message message) {
				System.out.println("Got the message "+message.toString());
			}
        });
    }

    @Bean
    public DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
       // factory.setMessageConverter(mappingJackson2MessageConverter());
        return factory;
    }	
	
	@Bean
    public ConnectionFactory connectionFactory() {
      CachingConnectionFactory factory=new CachingConnectionFactory("localhost");
      factory.setUsername("guest");
      factory.setPassword("guest");
      return factory;
    }

	@Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrentConsumers(3);
        factory.setMaxConcurrentConsumers(10);
        return factory;
    }
	/*
	@Bean
    public SimpleMessageListenerContainer messageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames(NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE);
        container.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(org.springframework.amqp.core.Message message) {
				System.out.println("Here Boss");	
			}
        });
        return container;
    }*/
}
