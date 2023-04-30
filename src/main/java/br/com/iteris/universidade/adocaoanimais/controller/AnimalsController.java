package br.com.iteris.universidade.adocaoanimais.controller;

import br.com.iteris.universidade.adocaoanimais.domain.dto.AnimalCreateRequest;
import br.com.iteris.universidade.adocaoanimais.service.AnimalsService;
import br.com.iteris.universidade.adocaoanimais.domain.entity.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AnimalsController {

    private final AnimalsService animalsService;
    public AnimalsController(final AnimalsService animalsService){
        this.animalsService = animalsService;
    }

    //List all animals
    @GetMapping (value = "api/animals")
    public ResponseEntity<List<Animal>> listar(){
        var animalList = animalsService.listar();
        return ResponseEntity.ok(animalList);
    }

    //Search animal by id
    @GetMapping (value = "api/animals/{id}")
    public ResponseEntity<Animal> searchById(@PathVariable Integer id){
        var animalResponse = animalsService.searchById(id);
        return ResponseEntity.ok(animalResponse);
    }

    //Search animal by name
    @GetMapping (value = "api/animals/name/{nameParam}")
    public ResponseEntity<Animal> searchByName (@PathVariable String nameParam){
        var animalResponse = animalsService.searchByName(nameParam);
        return ResponseEntity.ok(animalResponse);
    }

    //Create an animal with validations
    @PostMapping(value = "api/animals")
    public ResponseEntity<Animal> createAnimal(@RequestBody @Valid AnimalCreateRequest animal){
        var animalResponse = animalsService.createAnimal(animal);
        return ResponseEntity.ok(animalResponse);
    }

    @DeleteMapping(value = "api/animals/{id}")
    public ResponseEntity<Animal> deleteAnimal(@PathVariable Integer id) {
        var animalResponse = animalsService.deleteAnimal(id);
        return ResponseEntity.ok(animalResponse);
    }
}
