package com.aluracursos.registroanimales.service;

import com.aluracursos.registroanimales.model.Animal;
import com.aluracursos.registroanimales.model.TipoAnimal;
import com.aluracursos.registroanimales.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    //registrar animales

    public Animal registrarAnimal
            (Animal animal){
        return animalRepository.save(animal);
    }

    //animales por tipo

    public List<Animal> filtrarAnimalesPorTipo(TipoAnimal tipoAnimal){
        return animalRepository.animalesPorTipo(tipoAnimal);
    }

    public List<Animal> listarAnimal(){
        return animalRepository.findAll();
    }
}
