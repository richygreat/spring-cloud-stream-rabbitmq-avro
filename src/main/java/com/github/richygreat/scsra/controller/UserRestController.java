package com.github.richygreat.scsra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.richygreat.scsra.dto.UserDto;
import com.github.richygreat.scsra.stream.Source;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@Slf4j
public class UserRestController {
	@Autowired
	private Source source;

	@GetMapping
	public void getUser() {
		UserDto userDto = new UserDto();
		userDto.setId("1");
		userDto.setUserName("john");
		boolean messageSent = source.userProducer().send(MessageBuilder.withPayload(userDto).build());
		log.info("messageSent: {}", messageSent);
	}
}
