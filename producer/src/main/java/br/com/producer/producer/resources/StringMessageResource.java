package br.com.producer.producer.resources;

import br.com.producer.producer.service.GenerateProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/producer")
@Log4j2
public class StringMessageResource {

    @Autowired
    GenerateProducerService service;

    @PostMapping( value = "/send")
    public ResponseEntity<?> sendStringMessage(@RequestBody String message) {
        log.info("SENDING MESSAGE TO KAFKA");
        service.sendMessageToTopic(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
