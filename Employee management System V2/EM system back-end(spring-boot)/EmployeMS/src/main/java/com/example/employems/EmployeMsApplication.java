package com.example.employems;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeMsApplication.class, args);
	}

    @Bean
    public ModelMapper modelmapper(){

        return new ModelMapper();
    }

}
