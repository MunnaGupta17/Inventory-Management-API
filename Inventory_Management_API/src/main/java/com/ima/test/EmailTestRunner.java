package com.ima.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailTestRunner implements CommandLineRunner{
	
	@Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String fromEmail;

    @Override
    public void run(String... args) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo("mgabd17@gmail.com");
        message.setSubject("Test Email");
        message.setText("This is a test email from the Spring Boot application.");

        try {
            mailSender.send(message);
            System.out.println("Test email sent successfully");
        } catch (Exception e) {
            System.err.println("Error sending test email: " + e.getMessage());
        }
    }


}
