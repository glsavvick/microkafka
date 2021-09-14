package com.microservices.demo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialRandomBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.microservices.demo.config.RetryConfigData;

@Configuration
public class RetryConfig {
	
	private final RetryConfigData retryConfigData;
	
	public RetryConfig(RetryConfigData configData) {
		this.retryConfigData = configData;
	}
	
	@Bean
	public RetryTemplate retryTemplate() {
		RetryTemplate retryTemplate = new RetryTemplate();
		
		ExponentialRandomBackOffPolicy exponentialRandomBackOffPolicy = new ExponentialRandomBackOffPolicy();
		exponentialRandomBackOffPolicy.setInitialInterval(retryConfigData.getInitialIntervalMs());
		exponentialRandomBackOffPolicy.setMaxInterval(retryConfigData.getMaxIntervalMs());
		exponentialRandomBackOffPolicy.setMultiplier(retryConfigData.getMultiplier());
		
		retryTemplate.setBackOffPolicy(exponentialRandomBackOffPolicy);
		
		SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
		simpleRetryPolicy.setMaxAttempts(retryConfigData.getMaxAttempts());
		
		retryTemplate.setRetryPolicy(simpleRetryPolicy);
		
		return retryTemplate;
	}
	
}