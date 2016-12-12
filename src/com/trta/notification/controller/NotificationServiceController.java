package com.trta.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.trta.notification.configuration.NotificationConfiguration;
import com.trta.notification.constants.NotificationConstants;

@RestController
@RequestMapping(value="/notificationPipeline")
public class NotificationServiceController {

	@Autowired
	private NotificationConfiguration config;
	
	
	@RequestMapping(value="/Hello")
	public @ResponseBody String hello(@RequestParam("message") String message){
		return message;
	}
	
	@RequestMapping(value="/pushtoActiviti")
	public @ResponseBody String pushNotificationIntoActivitiWorkflow(@RequestParam("message") String message){
		try{
		//config.getChannel().basicPublish(NotificationConstants.XCHANGE,NotificationConstants.ACQUISITION_SERVICE_TOPIC, null, message.getBytes());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "Pushed "+message;
	}
	
	@RequestMapping(value="/pushtoEtl")
	public @ResponseBody String pushNotificationIntoEtl(@RequestParam("message") String message){
		try{
		//config.getChannel().basicPublish(NotificationConstants.XCHANGE,NotificationConstants.ECP_REGISTRAR_SERVICE_TOPIC, null, message.getBytes());
			}catch(Exception e){
				e.printStackTrace();
			}
		return "Pushed "+message;
	}

	
}
