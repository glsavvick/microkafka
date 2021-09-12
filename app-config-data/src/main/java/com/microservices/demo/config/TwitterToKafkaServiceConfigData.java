package com.microservices.demo.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix="app-config-data")
public class TwitterToKafkaServiceConfigData {

	private List<String> twitterKeywords;
	private String welcomeMessage;
	private Boolean enableMockTweets;
	private Long mockSleepMs;
	private Integer mockMinTweetLength;
	private Integer mockMaxTweetLength;

	
}
