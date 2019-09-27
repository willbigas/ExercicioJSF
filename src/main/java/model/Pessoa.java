package model;

import util.UtilDate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Pessoa {

    private String nome;
    private String email;
    private Date nascimento;
    private Integer idade;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getIdade() {
        LocalDate data = Instant
                .ofEpochMilli(this.nascimento.getTime())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(data, LocalDate.now()).getYears();
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
