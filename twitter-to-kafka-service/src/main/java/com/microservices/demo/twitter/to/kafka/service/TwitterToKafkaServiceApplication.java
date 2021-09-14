package com.microservices.demo.twitter.to.kafka.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.microservices.demo.config.TwitterToKafkaServiceConfigData;
import com.microservices.demo.twitter.to.kafka.service.init.StreamInitializer;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner{
	
	private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);
	
	// private final TwitterToKafkaServiceConfigData twitterToKafkaServiceConfigData;
	
	private final StreamRunner streamRunner;
	
	private final StreamInitializer streamInitializer;
	
	public TwitterToKafkaServiceApplication(/*TwitterToKafkaServiceConfigData configData, */StreamRunner streamRunner, StreamInitializer streamInitializer) {
		//this.twitterToKafkaServiceConfigData = configData;
		this.streamRunner = streamRunner;
		this.streamInitializer = streamInitializer;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("App starts.....");
		// LOG.info(Arrays.toString(twitterToKafkaServiceConfigData.getTwitterKeywords().toArray(new String[] {})));
		// LOG.info(twitterToKafkaServiceConfigData.getWelcomeMessage());
		streamInitializer.init();
		streamRunner.start();
	}

}
