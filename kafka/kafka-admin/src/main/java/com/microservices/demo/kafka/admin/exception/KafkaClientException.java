package com.microservices.demo.kafka.admin.exception;

public class KafkaClientException extends RuntimeException{

	public KafkaClientException() {
	}

	public KafkaClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public KafkaClientException(String message) {
		super(message);
	}
	
	
	
	

}
