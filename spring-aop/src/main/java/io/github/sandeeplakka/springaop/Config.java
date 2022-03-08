package io.github.sandeeplakka.springaop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {
    @Bean("red")
    public Car red() {
        return new Car("Ford", "Red");
    }

    @Bean("green")
    public Car green() {
        return new Car("Ford", "Green");
    }


}
