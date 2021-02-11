package com.mvidania.baautomation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("category")
    private Category category = null;

    @JsonProperty("name")
    private String name = null;

    @JsonIgnore
    @JsonProperty("photoUls")
    private List<String> photoUrls = new ArrayList<>();

    @JsonProperty("tags")
    private List<Tag> tags = new ArrayList<>();

    @JsonProperty("status")
    private String status = null;

}
