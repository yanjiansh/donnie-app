package com.donnie.grow.spring;

import org.springframework.stereotype.Component;

@Component
public class Message {

    public void say(String message){
        System.out.println(String.format("Message:%s", message));
    }
}
