package org.sid.notificationsender.controller;

import org.sid.notificationsender.PushNotificationRequestDto;
import org.sid.notificationsender.model.PushNotificationRequest;
import org.sid.notificationsender.model.PushNotificationResponse;
import org.sid.notificationsender.services.PushNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin("*")
public class PushNotificationController {

	
	
    private PushNotificationService pushNotificationService;
    
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }
    
    @PostMapping("/notification/token")
    public ResponseEntity<Object> sendTokenNotification(@RequestBody PushNotificationRequest request) {
        pushNotificationService.sendPushNotificationToToken(request);
        System.out.println(request.toString());
        System.out.println("princr");
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    @PostMapping("/notification/tokens")
    public ResponseEntity<Object> sendTokensNotification(@RequestBody PushNotificationRequestDto requestDto) {
    	System.out.println(requestDto.toString());
    	requestDto.getToken().forEach(t->{
    		 System.out.println("hiiiiiiiiiii");
    		PushNotificationRequest request = new PushNotificationRequest(requestDto.getTitle(),requestDto.getMessage(),requestDto.getTopic(),t);
    		pushNotificationService.sendPushNotificationToToken(request);
    		 System.out.println(request.toString());
    	});
        
       
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    
}