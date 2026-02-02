package com.aluracursos.registroanimales.repository;

import com.aluracursos.registroanimales.model.Animal;
import com.aluracursos.registroanimales.model.TipoAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnimalRepository extends JpaRepository <Animal,Long> {



    //Buscar animales por tipo
    @Query("select a from Animal a where a.tipoAnimal = :tipoAnimal")
    List<Animal> animalesPorTipo(@Param("tipoAnimal") TipoAnimal tipoAnimal);

    @Query("select sum(a.cantidad) from Animal a where a.tipoAnimal = :tipoAnimal")
    Integer cantidadTotalPorTipo(@Param("tipoAnimal") TipoAnimal tipoAnimal);


}
