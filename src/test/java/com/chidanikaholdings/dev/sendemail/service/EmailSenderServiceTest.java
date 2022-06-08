package com.chidanikaholdings.dev.sendemail.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author TJChidanika
 * @Date 8/6/2022
 * @TIME 09:46
 */
@SpringBootTest
@Slf4j
class EmailSenderServiceTest {
    @Autowired
    private EmailSenderService emailSenderservice;
    @Test
    public void testEmailSender(){
        emailSenderservice.sendEmail("tjchidanika@gmail.com","Test email sender","Test email subject");
        log.info("Email sent");
    }
}