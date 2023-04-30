package br.com.iteris.universidade.adocaoanimais.domain.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AnimalCreateRequest {
    @NotEmpty(message = "Name needs to be defined!")
    private String name;

    @NotNull(message = "Age needs to be defined!")
    private Integer age;

    @NotEmpty(message = "Specie needs to be defined!")
    private String specie;

    private Date birthDate;

    @Range(min = 1, max = 5, message = "Cuteness level must be between 1 and 5")
    private int cutenessLevel;

    @Range(min = 1, max = 5, message = "Affection level must be between 1 and 5")
    private int affectionLevel;

    @Email(message = "Email address needs do be valid!")
    private String email;
}
