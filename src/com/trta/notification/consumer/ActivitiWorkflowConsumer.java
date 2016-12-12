package com.trta.notification.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.trta.notification.constants.NotificationConstants;

@Component
public class ActivitiWorkflowConsumer{

	
	@RabbitListener(bindings = @QueueBinding(
	        value = @Queue(value = com.trta.notification.constants.NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE),
	        exchange = @Exchange(value = NotificationConstants.XCHANGE, type=NotificationConstants.EXCHNAGE_MODE))
	)
    public void onConsume(Message message) {
		String msg=new String(message.getBody());
		System.out.println("Listening to Farid : "+msg);
	}
}
