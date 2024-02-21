package br.com.producer.producer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GenerateProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendMessageToTopic(String message){
        kafkaTemplate.send("topico-projeto", message);
    }
}
