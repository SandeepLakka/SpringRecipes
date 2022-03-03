package io.github.sandeeplakka.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String _id;
    private String[] tags;
    private String content;
    private String author;

}
