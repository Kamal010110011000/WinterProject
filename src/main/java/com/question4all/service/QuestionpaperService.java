package com.question4all.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.question4all.model.Questionpaper;
import com.question4all.repository.QuestionPaperRepository;

@Service
public class QuestionpaperService {

	@Autowired
	QuestionPaperRepository questionRepository;
	
	
	public void addQuestionPaper(Questionpaper questionpaper) {
		questionRepository.save(questionpaper);
	}
	
	public void showQuestionPapers() {
		
	}
}
