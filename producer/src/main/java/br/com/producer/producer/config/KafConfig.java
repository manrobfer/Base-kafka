package br.com.producer.producer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Configuration
public class KafConfig {

    private final KafkaProperties kafkaProperties;
    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> conf = new HashMap<>();
        conf.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(conf);
       }
    @Bean
    public KafkaAdmin.NewTopics topcis(){
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("topico-projeto").partitions(2).replicas(1).build()
                );

    }

}
