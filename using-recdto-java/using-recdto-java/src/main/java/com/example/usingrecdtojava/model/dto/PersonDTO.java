package com.example.usingrecdtojava.model.dto;

import com.example.usingrecdtojava.model.Person;
import org.jetbrains.annotations.NotNull;

import java.io.Serial;
import java.io.Serializable;


public class PersonDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = - 1085409106691105476L;

    private String cpf;

    public PersonDTO(){

    }

    public PersonDTO(Person person){
        this.cpf = person.getCpf();
    }

    public Person toPerson(){
        return new Person(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
