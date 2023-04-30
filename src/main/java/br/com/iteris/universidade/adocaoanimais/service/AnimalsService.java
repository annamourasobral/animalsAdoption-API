package br.com.iteris.universidade.adocaoanimais.service;


import br.com.iteris.universidade.adocaoanimais.domain.dto.AnimalCreateRequest;
import br.com.iteris.universidade.adocaoanimais.domain.entity.Animal;
import br.com.iteris.universidade.adocaoanimais.exception.AnimalInvalidException;
import br.com.iteris.universidade.adocaoanimais.exception.AnimalNotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalsService {
    private static List<Animal> animalList;
    private static int nextId = 1;
    SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");

    @SneakyThrows
    public AnimalsService() {
        if (animalList == null) {
            animalList = new ArrayList<>();
            animalList.add(new Animal(nextId++, "Snape", 1, "Dog", ft.parse("2020-10-25"), 5, 5, "jainyestefany@hotmail.com"));
            animalList.add(new Animal(nextId++, "Mel", 1, "Cat", ft.parse("2022-04-22"), 5, 5, "flavia@gmail.com"));
            animalList.add(new Animal(nextId++, "Stuart", 2, "Rabbit", ft.parse("2019-09-13"), 5, 5, "jainyestefany@hotmail.com"));
            animalList.add(new Animal(nextId++, "Eduardo", 3, "Capybara", ft.parse("2020-10-14"), 5, 5, "jainyestefany@hotmail.com"));
        }
    }

    public Animal createAnimal(AnimalCreateRequest animalCreateRequest){
        //Rules
        //Just accept dog, cat, rabbit or capybara
        if(!speciesAvailable().contains(animalCreateRequest.getSpecie())){
            throw new AnimalInvalidException("The animal must be Dog, Cat, Rabbit or Capybara!");
        }
        //all right
        var newAnimal = new Animal(nextId++, animalCreateRequest.getName(), animalCreateRequest.getAge(), animalCreateRequest.getSpecie(), animalCreateRequest.getBirthDate(), animalCreateRequest.getCutenessLevel(), animalCreateRequest.getAffectionLevel(), animalCreateRequest.getEmail());
        animalList.add(newAnimal);

        return newAnimal;
    }
    public List<String> speciesAvailable(){
        List<String> species = new ArrayList<String>();
        species.add("Dog");
        species.add("Cat");
        species.add("Rabbit");
        species.add("Cabybara");
        return species;
    }

    //List animals
    public List<Animal> listar(){
        return animalList;
    }

    //Search by id
    public Animal searchById(Integer idAnimal){
        var animalFound = animalList.stream()
                .filter(animal -> animal.getIdAnimal() == idAnimal)
                .findFirst();

        if (animalFound.isEmpty()){
            throw new AnimalNotFoundException();
        }

        return animalFound.get();
    }

    //Search by name
    public Animal searchByName(String name){
        var animalFound = animalList.stream()
                .filter(animal -> animal.getName().equals(name))
                .findFirst();
        if(animalFound.isEmpty()){
            throw new AnimalNotFoundException();
        }

        return animalFound.get();
    }

    //Delete by id
    public Animal deleteAnimal(Integer id) {
        var animalFound = animalList.stream()
                .filter(animal -> animal.getIdAnimal() == id)
                .findFirst();

        if (animalFound.isEmpty()) {
            throw new AnimalNotFoundException();
        }

        var animal = animalFound.get();
        animalList.remove(animal);

        return animal;
    }
}