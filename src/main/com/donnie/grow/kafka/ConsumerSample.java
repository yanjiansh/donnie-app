package com.donnie.grow.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerSample {

    public static void main(String[] args){
        Properties p = new Properties();
        p.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        p.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        p.put(ConsumerConfig.GROUP_ID_CONFIG, ProducerSample.TOPIC);

        KafkaConsumer<String, String>  consumer = new KafkaConsumer<String, String>(p);
        consumer.subscribe(Collections.singletonList(ProducerSample.TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for ( ConsumerRecord<String, String> record : records) {
                System.out.println(String.format("Consume Msg, topic[%s],offset[%s],value[%s]", record.topic(), record.offset(), record.value()));
                consumer.commitSync();
            }
        }
    }
}
