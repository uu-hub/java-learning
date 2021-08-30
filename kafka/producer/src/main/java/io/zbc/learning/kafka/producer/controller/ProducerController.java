package io.zbc.learning.kafka.producer.controller;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zbc
 * @description
 * @date 2021/8/30 16:24
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    private static final String TOPIC = "topic-learning";

    @Autowired
    private KafkaTemplate<String, String> template;

    @RequestMapping("/send/{key}/{value}")
    public void sendToKafka(@PathVariable("key") String key, @PathVariable("value") String value) {
        ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC, 0, key, value);
        ListenableFuture<SendResult<String, String>> future = template.send(record);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
            }
            @Override
            public void onFailure(Throwable ex) {
            }
        });
    }

}
