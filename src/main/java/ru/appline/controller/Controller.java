package ru.appline.controller;


import org.springframework.web.bind.annotation.*;
import ru.appline.logic.Message;
import ru.appline.logic.Pet;
import ru.appline.logic.PetModel;
import ru.appline.logic.PetUpdate;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json", produces = "application/json")
    public Message createPet(@RequestBody Pet pet) {
        petModel.add(pet, newId.getAndIncrement());
        if(newId.intValue() == 2) {
            return new Message("Поздравляем! Теперь у вас есть питомец!");
        } else {
            return new Message("Поздравляем! Теперь у вас есть ещё один питомец!");
        }
    }


    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String, Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet/{id}", produces = "application/json")
    public Map<Integer, Pet> deletePet(@PathVariable int id) {
        if(petModel.containsKey(id)) {
            petModel.remove(id);
        }
        return petModel.getAll();
    }

    /*
    update pet:
    {
     "id": id_number,
     "pet": {
                "name": "newname",
                "type": "newtype",
                "age": newage_number
           }
    }
    */
    @PutMapping(value = "/updatePet", consumes = "application/json", produces = "application/json")
    public Map<Integer, Pet> updatePet(@RequestBody PetUpdate update) {
        if(petModel.containsKey(update.getId())) {
            petModel.add(update.getPet(), update.getId());
        }
        return petModel.getAll();
    }
}
