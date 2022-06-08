package com.chidanikaholdings.dev.sendemail.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author TJChidanika
 * @Date 8/6/2022
 * @TIME 10:07
 */
@SpringBootTest
class EmailSenderControllerTest {
    @Autowired
    private EmailSenderController emailSenderController;
    @Test
    public void sendEmail(){
        emailSenderController.sendEmail("tjchidanika@gmail.com","Test email sender controller","Test email subject controller");
    }

}