package br.com.kafka.consumer.listeners;

import br.com.kafka.consumer.config.CustomListener;
import br.com.kafka.consumer.model.Pessoa;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class Listen {

    /*
    @SneakyThrows
    @KafkaListener(groupId = "Group-2", topics = "topico-projeto", containerFactory = "consumerValid")
    public void listenerValid(String message){
        log.info(" LOG-INICIO EXCEPTION >>>>  Recebida a mensagem {}", message);

    }

    @KafkaListener(groupId = "Group-1", topics = "topico-projeto", containerFactory = "consumer")
    public void listener(String message){
        log.info(" LOG-INICIO >>>>  Recebida a mensagem {}", message);
    }

    @KafkaListener(groupId = "Group-0", topics = "topico-projeto", containerFactory = "consumer")
    public void listener0(String message){
        log.info("LOG-0 >>>>  Recebida a mensagem {}", message);
    }
    @KafkaListener(groupId = "Group-1", topics = "topico-projeto", containerFactory = "consumer")
    public void listener1(String message){
        log.info(" LOG1 ::: >>>>  Recebida a mensagem {}", message);
    }

    @KafkaListener(groupId = "Group-2", topicPartitions = { @TopicPartition( topic = "topico-projeto", partitions = {"0"})},containerFactory = "consumer")
    public void listener2(String message){
        log.info(" LOG2 ::: >>>>  Recebida a mensagem {}", message);
    } */

    @SneakyThrows
    @CustomListener(groupId = "Group-2")
    public void customListener(String message){
        log.info(" LOG2 CUSTOM::: >>>>  Recebida a mensagem {}", message);
        throw new IllegalArgumentException("EXCESSAO PERSONALIZADA :: ...");
    }

    @KafkaListener(topics = "topico-pessoa", groupId = "Group-1", containerFactory = "pessoaContainerFactory")
    public void pessoaListener(@Payload Pessoa pessoa){
        log.info(" Dados pessoa recebido");
        log.info(pessoa.toString());


    }

}
