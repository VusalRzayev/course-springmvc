package com.courseapp.controller;

import com.courseapp.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

        @MessageMapping("/routeMessage")
        @SendTo("/chat/messages")
        public Message routeMessage(Message m){
               String requestMessageContent= m.getContent();
               int requestMessageId=m.getUserId();
                Message message=new Message();
                message.setUserId(requestMessageId);
                message.setContent(requestMessageContent);
                return message;
        }
}
