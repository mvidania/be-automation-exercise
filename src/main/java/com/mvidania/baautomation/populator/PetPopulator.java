package com.mvidania.baautomation.populator;

import com.mvidania.baautomation.models.Category;
import com.mvidania.baautomation.models.Pet;
import com.mvidania.baautomation.models.PetEnum;
import com.mvidania.baautomation.models.Tag;
import java.util.ArrayList;
import java.util.List;

public class PetPopulator {

    public static Pet populateNewPet(){

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add("photo 1");
        photoUrls.add("photo 2");
        photoUrls.add("photo 3");

        Category category = Category.builder().id((long)12).name("Dogs").build();

        List<Tag> tagList = new ArrayList<>();

        Tag tag1 = Tag.builder().id((long)1).name("First tag").build();
        Tag tag2 = Tag.builder().id((long)2).name("Second tag").build();
        tagList.add(tag1);
        tagList.add(tag2);

        Pet newPet = Pet.builder()
                            .status(PetEnum.AVAILABLE.getValue())
                            .name("My new Pet")
                            .photoUrls(photoUrls)
                            .category(category)
                            .tags(tagList)
                            .build();

        return newPet;
    }
}
