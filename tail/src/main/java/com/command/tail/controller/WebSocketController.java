package com.command.tail.controller;

import com.command.tail.file.LogText;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    /**
     * Establishing Websocket connection
     * @param logText {@link LogText}
     * @return {@link LogText}
     */
    @MessageMapping("/chat.getLogs")
    @SendTo("/topic/public")
    public LogText sendMessage(
            @Payload LogText logText
    ) {
        return logText;
    }
}