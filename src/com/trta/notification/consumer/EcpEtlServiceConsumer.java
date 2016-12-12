package com.trta.notification.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.trta.notification.constants.NotificationConstants;


@Component
public class EcpEtlServiceConsumer {

	@RabbitListener(bindings = @QueueBinding(
	        value = @Queue(value = com.trta.notification.constants.NotificationConstants.ACQUISITION_SERVICE_TO_ACTIVITI_WORKFLOW_QUEUE+"3"),
	        exchange = @Exchange(value = NotificationConstants.XCHANGE, type=NotificationConstants.EXCHNAGE_MODE))
	)
    public void onPackageRegisteredMessage(Message message) {
    	String msg=new String(message.getBody());
		System.out.println("Listening to Farid3 : "+msg);
}
	
	@RabbitListener(bindings = @QueueBinding(
	        value = @Queue(value = com.trta.notification.constants.NotificationConstants.ECP_REGISTRAR_TO_ECP_ETL_QUEUE),
	        exchange = @Exchange(value = NotificationConstants.XCHANGE, type=NotificationConstants.EXCHNAGE_MODE))
	)
    public void onanothermsg(Message message) {
    	String msg=new String(message.getBody());
		System.out.println("Listening to Farid2 : "+msg);
}
}