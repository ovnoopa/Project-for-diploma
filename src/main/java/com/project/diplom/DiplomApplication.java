package com.project.diplom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;


import java.util.Locale;



@ImportResource("spring_mvc_config.xml")
@SpringBootApplication
public class DiplomApplication {


	public static void main(String[] args) {
		SpringApplication.run(DiplomApplication.class, args);

	}

}
