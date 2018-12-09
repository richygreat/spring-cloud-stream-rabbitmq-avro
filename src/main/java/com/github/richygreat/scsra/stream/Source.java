package com.github.richygreat.scsra.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Source {
	String USER_PRODUCER = "userProducer";

	@Output(USER_PRODUCER)
	MessageChannel userProducer();
}
