package br.com.producer.producer.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Pessoa implements Serializable {

    private long id;
    private int codid;
    private String nome;
    private int idade;
    private double salario;
    private Date nascimento;
}
