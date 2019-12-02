package com.question4all.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.question4all.model.Questionpaper;
import com.question4all.service.QuestionpaperService;

@Controller
public class QuestionUploadController {
	
	public static String uploadDir=System.getProperty("user.dir")+"/uploade";
	
	@Autowired
	QuestionpaperService questionpaper;
	
	
	
	@PostMapping(value="/admin/uploaded")
	public String questionUpload(Model model,@RequestParam("course")String course,@RequestParam("branch")String branch,@RequestParam("subject")String subject,@RequestParam("files")MultipartFile file,@RequestParam("topic")String topic,@RequestParam("semester")int semester) {
		Path fileNameAndPath= Paths.get(uploadDir,file.getOriginalFilename());
		new File(QuestionUploadController.uploadDir).mkdir();
		System.out.print(course+" "+branch+" "+semester+" "+subject+" "+topic+" "+fileNameAndPath.toString()+" ");
		Questionpaper question=new Questionpaper();
		question.setCourse(course);
		question.setFilepath(fileNameAndPath.toString());
		question.setSemester(semester);
		question.setSubject(subject);
		question.setTopic(topic);
		question.setBranch(branch);
		
		questionpaper.addQuestionPaper(question);
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "index";
	}
}
