package br.com.kafka.consumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ExceptionHandler implements KafkaListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info(" >>>>>  EXCEPTION HANDLER :::: <<<<<<<<");
        return null;
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
    }

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer, Acknowledgment ack) {
        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer, ack);
    }
}
