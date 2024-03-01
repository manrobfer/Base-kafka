package br.com.kafka.consumer.model;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class Pessoa {

    private long id;
    private int codid;
    private String nome;
    private int idade;
    private double salario;
    private Date nascimento;
}
