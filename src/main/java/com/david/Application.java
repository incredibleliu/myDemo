package com.david;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.david.batch.BatchConfig;

@EnableBatchProcessing
@SpringBootApplication
public class Application {
	


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
//		SpringApplication.run(BatchConfig.class, args);

	}
}
