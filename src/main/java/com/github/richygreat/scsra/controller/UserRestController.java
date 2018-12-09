package com.github.richygreat.scsra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.richygreat.scsra.dto.RoleDtoV1;
import com.github.richygreat.scsra.dto.UserDtoV1;
import com.github.richygreat.scsra.dto.UserDtoV2;
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
		UserDtoV1 userDtoV1 = UserDtoV1.newBuilder().setId("1").setUserName("john").build();
		boolean messageSent = source.userProducer().send(MessageBuilder.withPayload(userDtoV1).build());
		log.info("messageSent: {}", messageSent);

		UserDtoV2 userDtoV2 = UserDtoV2.newBuilder().setId(1L).setUserName("john").build();
		messageSent = source.userProducer().send(MessageBuilder.withPayload(userDtoV2).build());
		log.info("messageSent: {}", messageSent);

		RoleDtoV1 roleDtoV1 = RoleDtoV1.newBuilder().setId("1").setRoleName("Admin").build();
		messageSent = source.roleProducer().send(MessageBuilder.withPayload(roleDtoV1).build());
		log.info("messageSent: {}", messageSent);
	}
}
