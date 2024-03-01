package br.com.producer.producer.resources.impl;

import br.com.producer.producer.model.Pessoa;
import br.com.producer.producer.resources.PessoaResrouce;
import br.com.producer.producer.service.PessoaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/person")
public class PessoaResourceImpl implements PessoaResrouce {

    private final PessoaService pessoaService;
    @Override
    public ResponseEntity<Pessoa> pessoa(Pessoa pessoa) {
        log.info(" Enviando uma pessoa :::");
        pessoaService.enviaPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
