package com.question4all;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.question4all.controller.QuestionUploadController;

@SpringBootApplication
public class Question4AllApplication {

	public static void main(String[] args) {
		new File(QuestionUploadController.uploadDir).mkdir();
		SpringApplication.run(Question4AllApplication.class, args);
	}

}
