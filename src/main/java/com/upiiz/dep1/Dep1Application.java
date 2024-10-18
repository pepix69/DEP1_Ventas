package com.upiiz.dep1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.beans.ExceptionListener;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Dep1Application {

	public static void main(String[] args) {
		SpringApplication.run(Dep1Application.class, args);
	}

}
