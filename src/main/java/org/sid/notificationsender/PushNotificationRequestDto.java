package org.sid.notificationsender;

import java.util.ArrayList;
import java.util.List;




import lombok.Data;

import lombok.ToString;


@ToString @Data
public class PushNotificationRequestDto {
	
		private String title;
		private String message;
    	private String topic;
		private List<String> token = new ArrayList<>();
	

	
	
}
 

