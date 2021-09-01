package io.zbc.learning.kafka.producer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author zbc
 * @description
 * @date 2021/8/31 10:50
 */
@Service
public class ProducerService {

    private static final String TOPIC = "topic-learning";
    private static final Integer PARTITION = 0;

    @Autowired
    private KafkaTemplate<String, String> template;

    public void sendToKafka(String key, String value) {
        final ProducerRecord<String, String> record = createRecord(key, value);
        ListenableFuture<SendResult<String, String>> future = template.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("Send to kafka success.");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Send to kafka failure.");
            }
        });
    }

    public ProducerRecord<String, String> createRecord(String key, String value) {
        return new ProducerRecord<String, String>(TOPIC, key, value);

    }
}
