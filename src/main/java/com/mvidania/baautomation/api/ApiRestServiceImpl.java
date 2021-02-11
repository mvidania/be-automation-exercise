package com.mvidania.baautomation.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvidania.baautomation.models.Pet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Service
public class ApiRestServiceImpl implements ApiRestService {

    @Value("${app.petstore.uri}")
    private String petBaseURI;

    @Value("${app.petstore.pet.path}")
    private String petPath;

    private ObjectMapper mapper;

    private static final String PET_STATUS="status";
    private static final String FIND_BY_STATUS="/findByStatus";

    private static final Logger LOG = LoggerFactory.getLogger(ApiRestServiceImpl.class);

    public ApiRestServiceImpl(){
        this.mapper = new ObjectMapper();
    }

    @Override
    public Response getPetById(String id) throws Exception {
        RestAssured.baseURI=petBaseURI.concat(petPath);
        Response response = given()
                            .contentType(ContentType.JSON)
                            .get("/"+id);

        if(response.getStatusCode() == 400 ){
            LOG.error("****** Invalid Id supplied to API ******");
            throw new Exception();
        }
        LOG.info("Getting pet with id={} | Response status = {}  | BodyResponse={}",id,response.getStatusCode(),response.getBody().prettyPrint());
        return response;
    }

    @Override
    public Response getPetsByStatus(String[] statuses) throws Exception {
        String URL = petBaseURI.concat(petPath).concat(FIND_BY_STATUS);
        Map<String, String> parameters = new HashMap<>();
        for(String status : statuses){
            parameters.put(PET_STATUS,status);
        }
        Response response = given()
                .queryParams(parameters)
                .when()
                .get(URL);
        LOG.info("Getting pets with status {} | Response status = {}  | BodyResponse = {}", Arrays.toString(statuses),
                                                                                            response.getStatusCode(),
                                                                                            response.getBody().toString());
        if(response.getStatusCode() == 400) {
            LOG.error("****** Invalid status value requested *********");
            throw new Exception();
        }
        return response;
    }

    @Override
    public Response saveOrUpdatePet(Pet pet) throws Exception {
        String URL = petBaseURI.concat(petPath);
        String requestBody = mapper.writeValueAsString(pet);
        Response response = given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post(URL)
                .then()
                .extract().response();

        if(response.getStatusCode() == 405){
            LOG.error("****** Invalid request sent to POST action ******");
            throw new Exception();
        }
        LOG.info("Updated pet with id = {} | Response status = {}  | BodyResponse = {}", pet.getId(), response.getStatusCode(), response.getBody().prettyPrint());

        return response;
    }

    @Override
    public Response deletePet(Pet pet) throws Exception {
        String URL = petBaseURI.concat(petPath);
        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete(URL.concat("/").concat(pet.getId().toString()))
                .then()
                .extract().response();

        if(response.getStatusCode() == 400 ){
            LOG.error("****** Invalid Id supplied to API ******");
            throw new Exception();
        } else if(response.getStatusCode() == 404){
            LOG.error("****** Pet not found  ******");
            throw new Exception();
        }

        LOG.info("Deleted pet with id = {} | Response status = {}  | BodyResponse = {}", pet.getId(), response.getStatusCode(), response.getBody().prettyPrint());
        return response;
    }

}
