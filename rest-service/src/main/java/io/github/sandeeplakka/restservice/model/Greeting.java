package io.github.sandeeplakka.restservice.model;

import lombok.Data;

@Data
//Lombok's @Data annotation makes this POJO a data class, meaning
//POJO class having all fields getters, setters for fields which are not final
//Constructor with required fields ( final and NonNull annotated fields)
//@Data also gives us equals and hashcode implementations for all non-transient fields
//In our case, getters, all args constructor, equals and hashcode,
//and toString for both fields are generated
public class Greeting {
    private final Long id;
    private final String content;
}
