package com.github.richygreat.scsra.stream;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.github.richygreat.scsra.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class StreamConsumer {
	@StreamListener(Sink.USER_CONSUMER)
	public void consumeUser(Message<UserDto> message) {
		log.info("message: {}", message);
	}
}
