package com.aluracursos.registroanimales.principal;

import com.aluracursos.registroanimales.model.Animal;
import com.aluracursos.registroanimales.model.TipoAnimal;
import com.aluracursos.registroanimales.repository.AnimalRepository;
import com.aluracursos.registroanimales.service.AnimalService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Principal {



    private final Scanner teclado = new Scanner(System.in);
    private final AnimalService animalService;
    private final AnimalRepository animalRepository;

    public Principal(AnimalService animalService, AnimalRepository animalRepository) {
        this.animalService = animalService;
        this.animalRepository = animalRepository;
    }


    public void muestraElMenu() {
            var opcion = -1;
            while (opcion != 0) {


                var menu = """
                        
                        1 - Registrar datos de animales
                        2 - Consultar cantidad de animales por tipo
                        3 - listar animales en tu propiedad
                        
                        0 - Salir
                        """;
                System.out.println(menu);
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        registrarAnimales();
                        break;
                    case 2:
                        animalesPorTipo();
                        break;
                    case 3:
                        listarAnimales();
                        break;

                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");

                }
            }
        }


    private void registrarAnimales() {
        System.out.println("Nombre del animal (gallina, pato, vaca,ternero,etc): ");
        var nombreAnimal= teclado.nextLine();

        System.out.println("Esscribe el tipo de animal (AVE,\n" +
                "    CERDO,\n" +
                "    VACUNO,\n" +
                "    CORDERO)");
        var tipoAnimal= teclado.nextLine();
        System.out.println("¿qué cantidad quieres registrar?: ");
        var cantidad=teclado.nextInt();
        System.out.println("¿qué edad promedio tienen?");
        var edad =teclado.nextInt();

        Animal animal= new Animal();
        animal.setNombreAnimal(nombreAnimal);
        animal.setTipoAnimal(TipoAnimal.valueOf(tipoAnimal));
        animal.setCantidad(cantidad);
        animal.setEdad(edad);

        animalService.registrarAnimal(animal);
    }
    private void animalesPorTipo() {
        System.out.println("""
                Que tipo de animal que deseas buscar:
                AVE
                CERDO
                VACUNO
                CORDERO
                """);
        var buscarAnimal= teclado.nextLine().toUpperCase();

        List<Animal> animalBuscado=  animalService.filtrarAnimalesPorTipo(TipoAnimal.valueOf(buscarAnimal));

        System.out.println(animalBuscado);

        Integer cantidadTotal = animalRepository.cantidadTotalPorTipo(TipoAnimal.valueOf(buscarAnimal));
        System.out.println("Cantidad total: " + (cantidadTotal != null ? cantidadTotal : 0));

    }
    private void listarAnimales() {

        System.out.println("Estos son los animales en tu propiedad: ");

        var animalesPropios =animalService.listarAnimal();
        System.out.println(animalesPropios);
    }

}
