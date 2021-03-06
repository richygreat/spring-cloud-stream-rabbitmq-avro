package com.github.richygreat.scsra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.schema.server.EnableSchemaRegistryServer;

import com.github.richygreat.scsra.stream.Sink;
import com.github.richygreat.scsra.stream.Source;

@SpringBootApplication
@EnableBinding({ Source.class, Sink.class })
@EnableSchemaRegistryServer
@EnableSchemaRegistryClient
public class SCSRABootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SCSRABootApplication.class, args);
	}
}
