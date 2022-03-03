package io.github.sandeeplakka.consumingrest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@Slf4j
@SpringBootApplication
public class ConsumingRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    //TODO : Need to write Testcases and exceptional handling
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        final String URL = "https://api.quotable.io/random";
        String finalURL = URL;
        return args -> {
            Quote quote = restTemplate.getForObject(finalURL, Quote.class);
            log.info(quote.toString());
            log.info("\n:------");
            log.info(String.format("%s  -- %s", quote.getContent(),quote.getAuthor()));
        };
    }
}
