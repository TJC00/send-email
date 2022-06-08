package com.chidanikaholdings.dev.sendemail.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author TJChidanika
 * @Date 8/6/2022
 * @TIME 10:46
 */
@RestController
@RequestMapping("/")
@Slf4j
public class HomeController {
    @GetMapping("")
    public String home(){
        return "Welcome Home";
    }
    @PostMapping("")
    public ResponseEntity<String> greeting(@RequestParam(required=true)String name,
                                           @RequestParam(required = true) String message){

        HttpStatus messageStatus = HttpStatus.OK;
        if(message == null){
            messageStatus = HttpStatus.BAD_REQUEST;
        }
        else{
            messageStatus = HttpStatus.ACCEPTED;
        }

        return new ResponseEntity<>("Welcome "+name, messageStatus);
    }
}
