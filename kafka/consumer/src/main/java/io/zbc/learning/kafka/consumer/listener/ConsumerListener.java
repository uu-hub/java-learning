package io.zbc.learning.kafka.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zbc
 * @description
 * @date 2021/8/31 16:53
 */
@Service
@Slf4j
public class ConsumerListener {

    @KafkaListener(id = "listen", topics = "topic-learning",
            containerFactory = "kafkaListenerContainerFactory",
            autoStartup = "${listen.auto.start:true}", concurrency = "${listen.concurrency:3}")
    public void listen(ConsumerRecord<String, String> record) {
        log.info(record.topic());
        log.info(record.key());
        log.info(record.value());
        log.info(String.valueOf(record.partition()));
        log.info(String.valueOf(record.offset()));
        log.info(String.valueOf(record.timestamp()));
    }

    /**
     * batch
     */
    @KafkaListener(id = "listenBatch", topics = {"topic-learning", "test"},
            containerFactory = "batchFactory", groupId = "group-batch")
    public void listenBatch(List<ConsumerRecord<String, String>> records) {
        log.info(records.get(0).topic());
        log.info(records.get(0).key());
        log.info(records.get(0).value());
        log.info(String.valueOf(records.get(0).partition()));
        log.info(String.valueOf(records.get(0).offset()));
        log.info(String.valueOf(records.get(0).timestamp()));
    }
}
