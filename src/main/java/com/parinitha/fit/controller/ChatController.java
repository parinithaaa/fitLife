package com.parinitha.fit.controller;

import org.springframework.ai.chat.client.ChatClient;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.parinitha.fit.service.ChatService;

@RestController
public class ChatController {
	
	private final ChatService chatService;
	
	public ChatController(ChatService service) {
		chatService = service;
	}
	
	@GetMapping("/chat")
	public String getResponse(@RequestParam String prompt) {
		return chatService.getResponses(prompt);
	}
	

}
