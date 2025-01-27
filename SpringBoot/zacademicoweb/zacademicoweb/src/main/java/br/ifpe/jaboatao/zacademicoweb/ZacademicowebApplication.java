package br.ifpe.jaboatao.zacademicoweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.ifpe.jaboatao.zacademicoweb.spring_boot","br.ifpe.jaboatao.zacademicoweb.model.dao"})
public class ZacademicowebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZacademicowebApplication.class, args);
	}

}
