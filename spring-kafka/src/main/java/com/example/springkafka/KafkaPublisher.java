package com.example.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.example.springkafka.Constants.TOPIC;

@Component
public class KafkaPublisher {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void send(String message) {
		//		log.info("+++++++++++++++++++++  message = {}", gson.toJson(message));
		kafkaTemplate.send(TOPIC, message);
	}
}