package com.mvidania.baautomation;

import com.mvidania.baautomation.api.ApiRestService;
import com.mvidania.baautomation.services.PetService;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public abstract class PetDemoIntegrationTest {

    @Autowired
    protected PetService petService;

    @Autowired
    protected ApiRestService apiService;

    protected Response response;
    protected final int RESPONSE_OK = 200;
    protected final int RESPONSE_NOT_FOUND = 404;

}
