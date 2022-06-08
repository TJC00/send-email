package com.chidanikaholdings.dev.sendemail.controller;

import com.chidanikaholdings.dev.sendemail.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author TJChidanika
 * @Date 8/6/2022
 * @TIME 10:03
 */
@RestController
@RequestMapping("mail")
public class EmailSenderController {
    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestParam("email") String email,
                                            @RequestParam("subject") String subject,
                                            @RequestParam("message") String message){
        String mail = emailSenderService.sendEmail(email,message,subject);

        return new ResponseEntity<>(mail, HttpStatus.OK);
    }
}
