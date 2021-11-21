package ru.appline.controller;

import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Compass;
import ru.appline.logic.CompassModel;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {

    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    private static CompassModel compassModel = CompassModel.getInstance();
    private static final Integer[] dde = new Integer[]{};

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/json")
    public String createPet(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        if (newId.get() == 2) return "Успешно создан первый питомец";
        else return "Питомец успешно создан";
    }


    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll(){
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/delPet", consumes = "application/json", produces = "application/json")
    public String delPes(@RequestBody Map<String, Integer> id) {
        petModel.delete(id.get("id"));
        return "Питомец удален";
    }

    @PutMapping(value = "/putPet/{petId}", consumes = "application/json", produces = "application/json")
    public Pet putPet(@PathVariable(name = "petId") int petId, @RequestBody Pet pet) {
        petModel.put(petId, pet);
        return petModel.getFromList(petId);
    }

    @PostMapping(value = "/createSide")
    public void createSide (@RequestBody Map<String, String> compass) {
        compassModel.add(compass);
    }

    @GetMapping(value = "/getSide", consumes = "application/json", produces = "application/json")
    public Compass getSide(@RequestBody Map<String, Integer> side) {
        return compassModel.getSide(side.get("Degree"));
    }



}
