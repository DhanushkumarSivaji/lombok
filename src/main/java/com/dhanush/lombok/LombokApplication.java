package com.dhanush.lombok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan("com.dhanush.lombok.*")
@ComponentScan({"com.dhanush.lombok.controller","com.dhanush.lombok.service"})
@EntityScan("com.dhanush.lombok.entity")
@EnableJpaRepositories("com.dhanush.lombok.repository")
@EnableSwagger2
public class LombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(LombokApplication.class, args);
	}

}
