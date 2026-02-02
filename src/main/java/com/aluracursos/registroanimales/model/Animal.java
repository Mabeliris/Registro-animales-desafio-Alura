package com.aluracursos.registroanimales.model;

import jakarta.persistence.*;

@Entity
@Table(name="animales")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreAnimal;

    @Enumerated(EnumType.STRING)
    private TipoAnimal tipoAnimal;

    private Integer cantidad;

    private Integer edad;

    public Animal() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return
                " nombreAnimal='" + nombreAnimal + '\'' +
                ", tipoAnimal=" + tipoAnimal +
                ", cantidad=" + cantidad ;

    }
}
