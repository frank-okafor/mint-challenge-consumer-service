package com.mint.challenge.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.mint.challenge.Dtos.OrderReports;

@Configuration
public class KafkaConfig {

	@Value("${spring.kafka.bootstrap-servers}")
	private String server;

	public Map<String, Object> consumerConfig() {
		Map<String, Object> confiqMap = new HashMap<>();
		confiqMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
		confiqMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		confiqMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, OrderReports.class);
		return confiqMap;
	}

	@Bean
	public ConsumerFactory<String, OrderReports> conumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfig());
	}

	@Bean
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, OrderReports>> containerFactory(
			ConsumerFactory<String, OrderReports> conumerFactor) {
		ConcurrentKafkaListenerContainerFactory<String, OrderReports> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(conumerFactor);
		return factory;
	}

}
