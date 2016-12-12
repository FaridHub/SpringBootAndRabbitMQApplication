package com.trta.notification.application;

import java.nio.charset.Charset;

import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import com.trta.notification.configuration.NotificationConfiguration;
import com.trta.notification.consumer.ActivitiWorkflowConsumer;

@SpringBootApplication
@ComponentScan(basePackages={"com.trta.notification"})
public class NotificationServiceApplication {

	
	public static void main(String... args){
		SpringApplication.run(NotificationServiceApplication.class,args);
		System.out.println("Notification Service Application Started! Ready to GO.");
	}
}
