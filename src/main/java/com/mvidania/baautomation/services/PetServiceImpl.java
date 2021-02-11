package com.mvidania.baautomation.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvidania.baautomation.api.ApiRestService;
import com.mvidania.baautomation.api.ApiRestServiceImpl;
import com.mvidania.baautomation.models.Pet;
import com.mvidania.baautomation.populator.PetPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.restassured.response.Response;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    ApiRestService apiService;

    private ObjectMapper mapper;

    Pet pet;

    public PetServiceImpl(){
        this.pet = new Pet();
        this.apiService = new ApiRestServiceImpl();
        this.mapper = new ObjectMapper();
    }

    @Override
    public List<Pet> getPetsByStatus (String [] statuses) throws Exception {
        List<Pet> petList;
        Response response = apiService.getPetsByStatus(statuses);
        petList = mapper.readValue(response.asString(),new TypeReference<List<Pet>>(){});
        return petList;
    }

    @Override
    public Pet getPetById(String id) throws Exception {
        Pet pet;
        Response response = apiService.getPetById(id);
        pet = mapper.readValue(response.asString(),Pet.class);
        return pet;
    }

    @Override
    public Pet postNewPetToTheStore() throws Exception {
        Pet pet;
        Pet newPet = PetPopulator.populateNewPet();
        Response response = apiService.saveOrUpdatePet(newPet);
        pet = mapper.readValue(response.asString(),Pet.class);
        return pet;
    }

    @Override
    public Pet saveOrUpdatePet(Pet pet) throws Exception {
        Response response = apiService.saveOrUpdatePet(pet);
        pet = mapper.readValue(response.asString(),Pet.class);
        return pet;
    }

}
