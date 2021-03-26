package br.com.recursosReact.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import br.com.recursosReact.fullstack.property.RecursosReactProperty;

@SpringBootApplication
@EnableConfigurationProperties(RecursosReactProperty.class)
public class RecursosReactApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecursosReactApplication.class, args);
	}

}
