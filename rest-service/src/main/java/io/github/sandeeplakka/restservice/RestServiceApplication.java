package io.github.sandeeplakka.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBootApplication is the combination of the following annotations and their use
//Configuration 			-> To register all beans if created into context
//EnableAutoConfiguration 	-> To let spring enable it's auto-config magic based on
//							-> To autoconfigure based on classpath, other beans and configurations
//ComponentScan				-> To enable component and its derivatives scanning from this package onwards
// 							-> Derivatives examples : @Service, @Repository, @Controller
@SpringBootApplication
public class RestServiceApplication {

	//Starting point of Spring boot application. It is from here that everything happens.
	public static void main(String[] args) {
		SpringApplication.run(RestServiceApplication.class, args);
	}

}
