package com.mvidania.baautomation.helpers;

import com.mvidania.baautomation.models.Pet;
import org.assertj.core.api.AbstractAssert;
import org.springframework.stereotype.Component;
import static org.junit.Assert.assertEquals;
import java.util.List;

@Component
public class PetsAssertion extends AbstractAssert<PetsAssertion,List<Pet>> {

    PetsAssertion(List<Pet> petList){
        super(petList, PetsAssertion.class);
    }

    public static void  checkEqualStatusAllPets(List<Pet> petList, String status){
        for(Pet pet : petList){
            assertEquals(pet.getStatus(),status);
        }
    }


}
