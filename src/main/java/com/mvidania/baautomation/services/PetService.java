package com.mvidania.baautomation.services;

import com.mvidania.baautomation.models.Pet;
import java.util.List;

public interface PetService {
    Pet getPetById(String id) throws Exception;
    List<Pet> getPetsByStatus (String [] statuses) throws Exception;
    Pet postNewPetToTheStore() throws Exception;
    Pet saveOrUpdatePet(Pet pet) throws Exception;
}
