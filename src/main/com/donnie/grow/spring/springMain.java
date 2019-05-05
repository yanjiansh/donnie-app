package com.donnie.grow.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.*;

@Service
public class springMain {
    @Resource
    private Message message;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Message msg = (Message) context.getBean("message");
        msg.say("Hello");
        MessageService msgService = (MessageService) context.getBean("msgService");
        msgService.print("Hello World!!");
    }
}
