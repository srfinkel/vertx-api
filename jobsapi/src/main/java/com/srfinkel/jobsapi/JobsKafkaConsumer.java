package com.srfinkel.jobsapi;

import java.util.HashMap;
import java.util.Map;

import io.vertx.core.Vertx;
import io.vertx.kafka.client.consumer.KafkaConsumer;

public class JobsKafkaConsumer {

	public void jobsConsumer(Vertx vertx) {

		Map<String, String> config = new HashMap<>();
		config.put("bootstrap.servers", "localhost:9092");
		config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		config.put("group.id", "jobsCounter");
		config.put("auto.offset.reset", "earliest");
		config.put("enable.auto.commit", "false");

		KafkaConsumer<String, String> consumer = KafkaConsumer.create(vertx, config);

		consumer.handler(record -> {
			System.out.println("Processing key=" + record.key() + ",value=" + record.value() + ",partition="
					+ record.partition() + ",offset=" + record.offset());
		});

		consumer.subscribe("jobs", ar -> {
			if (ar.succeeded()) {
				System.out.println("subscribed");
			} else {
				System.out.println("Could not subscribe " + ar.cause().getMessage());
			}
		});
	}
}
