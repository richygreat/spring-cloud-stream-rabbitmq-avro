package com.github.richygreat.scsra.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Sink {
	String USER_CONSUMER = "userConsumer";

	@Input(USER_CONSUMER)
	SubscribableChannel userConsumer();
}
