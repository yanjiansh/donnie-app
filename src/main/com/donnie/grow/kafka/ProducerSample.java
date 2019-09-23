package com.donnie.grow.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;

public class ProducerSample {

    public static final String TOPIC = "TOPIC-TEST";

    public static void main(String[] args) throws InterruptedException {
        Properties p = new Properties();
        p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(p);

        try {
            while (true) {
                String msg = "Hello, " + new Random().nextInt(100);
                ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, msg);
                producer.send(record);
                System.out.println("Msg send success.");
                Thread.sleep(500);
            }
        } finally {
            producer.close();
        }
    }
}
