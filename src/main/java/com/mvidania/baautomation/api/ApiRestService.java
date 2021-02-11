package com.mvidania.baautomation.api;

import com.mvidania.baautomation.models.Pet;
import io.restassured.response.Response;

public interface ApiRestService {
    Response getPetById(String id) throws Exception;
    Response getPetsByStatus(String[] statuses) throws Exception;
    Response saveOrUpdatePet(Pet pet) throws Exception;
    Response deletePet(Pet pet) throws Exception;
}
