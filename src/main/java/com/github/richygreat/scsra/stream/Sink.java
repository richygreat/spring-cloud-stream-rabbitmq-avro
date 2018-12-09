package com.github.richygreat.scsra.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
	String USER_CONSUMER = "userConsumer";
	String ROLE_CONSUMER = "roleConsumer";

	@Input(USER_CONSUMER)
	SubscribableChannel userConsumer();

	@Input(ROLE_CONSUMER)
	SubscribableChannel roleConsumer();
}
