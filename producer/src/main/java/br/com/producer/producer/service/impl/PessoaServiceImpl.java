package br.com.producer.producer.service.impl;

import br.com.producer.producer.model.Pessoa;
import br.com.producer.producer.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@Log4j2
@RequiredArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private final KafkaTemplate<String, Serializable> template;
    @Override
    public void enviaPessoa(Pessoa pessoa) {
       log.info("Pessoa informada {}", pessoa);
       template.send("topico-pessoa",pessoa);
    }
}
