package com.learning.quizapp_monolith.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.quizapp_monolith.model.Question;
import com.learning.quizapp_monolith.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	@Autowired
	QuestionService questionService;
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestion() {
		return questionService.getAllQuestion();
	}
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category){
		return questionService.getQuestionsByCategory(category);
	}
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
		
	};
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable Integer id) {
		return questionService.deleteQuestion(id);
	}
	@PutMapping("update")
	public ResponseEntity<String> updateQuestion(@RequestBody Question question) {
		return questionService.updateQuestion(question);
	}
}