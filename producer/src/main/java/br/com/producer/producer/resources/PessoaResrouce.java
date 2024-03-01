package br.com.producer.producer.resources;

import br.com.producer.producer.model.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PessoaResrouce {

    @PostMapping
    ResponseEntity<Pessoa> pessoa(@RequestBody Pessoa pessoa);
}
