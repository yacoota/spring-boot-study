package com.cacoota.study.controller;

import com.alibaba.fastjson.JSON;
import com.cacoota.framework.socket.WebSocketUser;
import com.cacoota.study.entry.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
@Slf4j
public class ChatController {

    @Autowired
    private SimpMessagingTemplate template;

    @GetMapping(value = {"", "/", "/index"})
    public String index() {
        return "chat/index";
    }


    @GetMapping("/send/public/{message}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String _public(@PathVariable("message") String msg) {
        String result = JSON.toJSONString(JSON.toJSON(new ChatMessage(msg)));
        template.convertAndSend("/topic/public", result);
        log.info("公共消息通道：{}", msg);
        return result;
    }

    @GetMapping("/send/single/{who}/{message}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String _private(@PathVariable("who") String who, @PathVariable("message") String msg) {
        String result = JSON.toJSONString(JSON.toJSON(new ChatMessage(who, msg)));
        template.convertAndSendToUser(who, "/queue/chat", result);
        log.info("私有消息通道：{}, {}", who, msg);
        return result;
    }

    // 订阅相关信息
    @SubscribeMapping("/topic/public'")
    public void subscribePublicMessage(StompHeaderAccessor header) {
        log.info("订阅公共消息内容:{}", header);
    }

    @SubscribeMapping("/queue/chat'")
    public void subscribePrivateMessage(StompHeaderAccessor header) {
        log.info("订阅私有消息内容:{}", header);
    }

    // 标准模式
    @MessageMapping("gmessage")
    public void sendPublicMessage(@Payload ChatMessage msg, @Header("simpUser") WebSocketUser user) {
        String result = JSON.toJSONString(msg);
        log.info("公共聊天内容:{}, 消息来源:{}", msg, user.getName());
        template.convertAndSend("/topic/public", result);
    }

    @MessageMapping("smessage")
    public void sendPrivateMessage(@Payload ChatMessage msg, StompHeaderAccessor header, @Header("simpUser") WebSocketUser user) {
        String result = JSON.toJSONString(msg);
        log.info("私有聊天内容:{}, 消息来源:{}", msg, user.getName());
        template.convertAndSendToUser(msg.getReceiver(), "/queue/chat", result);
    }

    @MessageMapping("message.precise")
    public void sendPreciseMessage(@Payload ChatMessage msg, StompHeaderAccessor header, @Header("simpUser") WebSocketUser user) {
        String result = JSON.toJSONString(msg);
        log.info("私有聊天内容:{}, 消息来源:{}", msg, user.getName());
        template.convertAndSendToUser(msg.getReceiver(), "/queue/chat", result);
    }

    // 注解方式
    @SendTo("/topic/public")
    public ChatMessage annoSendPublicMessage(@Payload ChatMessage msg, @Header("simpUser") WebSocketUser user) {
        log.info("注解公共聊天内容:{}, 消息来源:{}", msg, user.getName());
        return msg;
    }

    @SendToUser(value = "/queue/chat", broadcast = false)
    public ChatMessage annoSendPrivateMessage(@Payload ChatMessage msg, StompHeaderAccessor header, @Header("simpUser") WebSocketUser user) {
        log.info("注解私有聊天内容:{}, 消息来源:{}", msg, user.getName());
        return msg;
    }

}
