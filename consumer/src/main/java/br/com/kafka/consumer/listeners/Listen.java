package br.com.kafka.consumer.listeners;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class Listen {

    @KafkaListener(groupId = "Group-1", topics = "topico-projeto", containerFactory = "consumer")
    public void listener(String message){
        log.info(" >>>>  Recebida a mensagem {}", message);
    }

    @KafkaListener(groupId = "Group-0", topics = "topico-projeto", containerFactory = "consumer")
    public void listener0(String message){
        log.info(" >>>>  Recebida a mensagem {}", message);
    }
    @KafkaListener(groupId = "Group-1", topics = "topico-projeto", containerFactory = "consumer")
    public void listener1(String message){
        log.info(" >>>>  Recebida a mensagem {}", message);
    }

    @KafkaListener(groupId = "Group-2", topicPartitions = { @TopicPartition( topic = "topico-projeto", partitions = {"0"})},containerFactory = "consumer")
    public void listener2(String message){
        log.info(" >>>>  Recebida a mensagem {}", message);
    }

}
