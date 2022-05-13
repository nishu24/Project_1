package com.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication
public class EmailApiApplication{

//	@Autowired
//	private JavaMailSender javaMailSender;
	/**
	 *
	 */
//	void sendEmail(){
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setTo("neesarg@gmail.com","tonisargpanchal@gmail.com");
//		msg.setSubject("Testing email from Spring Boot Email API");
//		msg.setText("Hello India from :- Email API");
//		javaMailSender.send(msg);
//	}

	public static void main(String[] args) {
		SpringApplication.run(EmailApiApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception, MessagingException, IOException {
//		System.out.println("Sending Email...");
//
//		sendEmail();
//		//sendEmailWithAttachment();
//
//		System.out.println("Done");
//	}
}
