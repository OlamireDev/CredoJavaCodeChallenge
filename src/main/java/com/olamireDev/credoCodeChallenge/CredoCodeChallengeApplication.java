package com.olamireDev.credoCodeChallenge;

import com.twilio.Twilio;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class CredoCodeChallengeApplication {
	@Value("${twilo.sid}")
	public static  String SID;
	@Value("${twilo.token}")
	public static  String TOKEN;
	public static void main(String[] args) {
		setDetails();
		Twilio.init(SID, TOKEN);
		SpringApplication.run(CredoCodeChallengeApplication.class, args);
	}

	public static void setDetails(){
		Map<String, String> variables = new HashMap<>();
		InputStream inputStream = CredoCodeChallengeApplication.class.getClassLoader().getResourceAsStream(".env");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = reader.readLine()) != null) {
				variables.put(line.split("=")[0], line.split("=")[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		SID = variables.get("twilio.sid");
		TOKEN = variables.get("twilio.token");
	}

}
