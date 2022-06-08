package com.chidanikaholdings.dev.sendemail.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.webresources.FileResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.nio.file.FileSystem;

/**
 * @Author TJChidanika
 * @Date 8/6/2022
 * @TIME 09:39
 */
@Service
@Slf4j
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(String toEmail, String body, String subject){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("chidanikaholdings.dev@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        log.info("Message send to {} successfully",toEmail);
        return "Mail send successfully....";
    }
    public String sendEmailWithAttachment(String toEmail,String message, String subject, String attachment) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setTo("chidanikaholdings.dev@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(message);
        mimeMessageHelper.setSubject(subject);

        FileSystemResource fileSystem =
                new FileSystemResource(new File(attachment));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
        mailSender.send(mimeMessage);

        return "Message send successfully";
    }
}
