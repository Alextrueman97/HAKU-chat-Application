package haku.com.chatApplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import haku.com.chatApplication.models.Message;
import haku.com.chatApplication.models.OutputMessage;

@RestController("/chatApp")
@CrossOrigin(origins = "http://localhost:3000")
public class MessageController {

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	    @PostMapping("/chat")
	    public OutputMessage send(@RequestBody Message message) {
	        String time = new SimpleDateFormat("HH:mm").format(new Date());
	        OutputMessage outputMessage = new OutputMessage(message.getFrom(), message.getText(), time);
	        simpMessagingTemplate.convertAndSend("/topic/messages", outputMessage);
	        return outputMessage;
	    }
	
}

