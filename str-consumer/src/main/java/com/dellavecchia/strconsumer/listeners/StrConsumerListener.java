package com.dellavecchia.strconsumer.listeners;

import com.dellavecchia.strconsumer.custom.StrConsumerCustomListener;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListener(groupId = "group-1")
    public void create(String message) {
        log.info("create ::: Receive message {}", message);
        throw new IllegalArgumentException("EXCEPTION...");
    }

//        @KafkaListener(groupId = "group-1",
//            topicPartitions = {@TopicPartition(topic = "str-topic", partitions = {"1"})
//            },
//            containerFactory = "strContainerFactory")
    @StrConsumerCustomListener(groupId = "group-1")
    public void log(String message) {

        log.info("log ::: Receive message {}", message);

    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "validMessageContainerFactory")
    public void history(String message) {

        log.info("history ::: Receive message {}", message);

    }
}
