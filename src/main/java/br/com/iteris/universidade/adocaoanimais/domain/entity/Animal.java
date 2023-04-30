package br.com.iteris.universidade.adocaoanimais.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Animal {
    private int idAnimal;
    private String name;
    private Integer age;
    private String specie;
    private Date birthDate;
    private int cutenessLevel;
    private int affectionLevel;
    private String email;
}
