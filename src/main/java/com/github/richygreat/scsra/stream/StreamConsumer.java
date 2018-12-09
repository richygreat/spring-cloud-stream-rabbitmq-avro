package com.github.richygreat.scsra.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.github.richygreat.scsra.dto.RoleDtoV1;
import com.github.richygreat.scsra.dto.UserDtoV1;
import com.github.richygreat.scsra.dto.UserDtoV2;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StreamConsumer {
	@StreamListener(target = Sink.USER_CONSUMER, condition = "headers['contentType'].toString().contains('userdtov1')")
	public void consumeUserV1(Message<UserDtoV1> message) {
		log.info("consumeUserV1: message: {}", message);
	}

	@StreamListener(target = Sink.USER_CONSUMER, condition = "headers['contentType'].toString().contains('userdtov2')")
	public void consumeUserV2(Message<UserDtoV2> message) {
		log.info("consumeUserV2: message: {}", message);
	}

	@StreamListener(target = Sink.ROLE_CONSUMER, condition = "headers['contentType'].toString().contains('roledtov1')")
	public void consumeRoleV1(Message<RoleDtoV1> message) {
		log.info("consumeRoleV1: message: {}", message);
	}
}
