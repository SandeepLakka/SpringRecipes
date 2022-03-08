package io.github.sandeeplakka.springaop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class SpringAOPApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context  = SpringApplication.run( SpringAOPApplication.class, args);
        Arrays.stream(context.getBeanDefinitionNames())
                .map(beanName -> context.getBean(beanName))
                .map(o -> o.getClass().getName()+"||"+o.getClass().getTypeName())
                .filter(s -> s.contains("Car"))
                .forEach(System.out::println);

        log.info("------------------------------------------------");

        CarService carService = context.getBean(CarService.class);
        //carService.getRedCar();
        //carService.getGreenCar();

        carService.getCars();

    }
}

