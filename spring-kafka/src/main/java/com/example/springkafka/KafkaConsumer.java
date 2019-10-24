package com.example.springkafka;

import static com.example.springkafka.Constants.TOPIC;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	@KafkaListener(topics = { TOPIC })
	@SendTo
	public String listen(ConsumerRecord<?, ?> record) {
		String result = "";
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			result = String.valueOf(message);
			System.out.println("----------------- record =" + record);
			System.out.println("------------------ message =" + message);
//            log.info("----------------- record =" + record);
//            log.info("------------------ message =" + message);
		}
		return result.toUpperCase();
	}
}