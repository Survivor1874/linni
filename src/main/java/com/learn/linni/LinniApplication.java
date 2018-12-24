package com.learn.linni;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.learn.linni.dao")
public class LinniApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinniApplication.class, args);
	}

}

