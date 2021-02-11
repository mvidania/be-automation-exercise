package com.mvidania.baautomation.gherkinsteps.petdemo;

import com.mvidania.baautomation.PetDemoIntegrationTest;
import com.mvidania.baautomation.models.Pet;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.List;
import static com.mvidania.baautomation.helpers.PetsAssertion.checkEqualStatusAllPets;
import static org.junit.Assert.assertEquals;

public class GetAvailablePetSteps extends PetDemoIntegrationTest {

    private List<Pet> petList;
    private Pet pet;

    private static final Logger LOG = LoggerFactory.getLogger(GetAvailablePetSteps.class);

    @Given("The following API : {string}, Test GET, POST, UPDATE and DELETE")
    public void request_all_available_pets(String url) throws IOException {
        LOG.info("********* STARTING API TEST. Swagger: {}  ***************",url);
    }

    @When("The client request {string} pets")
    public void get_pet_by_status(String status1) throws Exception {
        String [] statuses = {status1};
        this.petList = petService.getPetsByStatus(statuses);
    }

    @Then("The client checks that all pets are {string}")
    public void check_all_pets_are_available(String status){
        checkEqualStatusAllPets(petList,status);
    }

    @When("The client adds a new pet")
    public void add_new_pet_to_the_store() throws Exception {
        this.pet = petService.postNewPetToTheStore();
        LOG.info("****** Pet status {} *******",this.pet.getStatus());
    }

    @Then("The client check that the pet is added")
    public void check_that_pet_is_added() throws Exception{
        Response response = apiService.getPetById(pet.getId().toString());
        assertEquals(RESPONSE_OK, response.statusCode());
    }

    @When("The client update pet with status {string}")
    public void update_pet_with_new_status(String status) throws Exception {
        this.pet.setStatus(status);
        this.pet = petService.saveOrUpdatePet(this.pet);
    }

    @Then("The client check that status has changed to {string}")
    public void check_new_status_update(String status){
        LOG.info("****** Pet status = {} *******",this.pet.getStatus());
        assertEquals(this.pet.getStatus(), status);
    }

    @When("The client delete this pet from the store")
    public void delete_pet_from_store() throws Exception {
        response = apiService.deletePet(this.pet);
    }

    @Then("The client check if the pet has been removed from the store")
    public void check_pet_is_already_deleted() throws Exception {
        response = apiService.getPetById(this.pet.getId().toString());
        assertEquals(RESPONSE_NOT_FOUND, response.statusCode());
    }
}
