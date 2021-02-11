package com.mvidania.baautomation.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
