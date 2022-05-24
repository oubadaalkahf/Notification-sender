package org.sid.notificationsender.services;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public abstract class FirebaseInitialize {
	@PostConstruct
	public void initialize() throws IOException {
		FileInputStream serviceAccount =
				  new FileInputStream("./serviceAccountKey.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://mwallethps-default-rtdb.firebaseio.com")
				  .build();

				FirebaseApp.initializeApp(options);
	}
}
