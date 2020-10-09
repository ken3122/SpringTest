package ru.appline.logic;

public class PetUpdate {
    private Pet pet;
    private int id;

    public PetUpdate() {
        super();
    }

    public PetUpdate(Pet pet, int id) {
        this.pet = pet;
        this.id = id;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
