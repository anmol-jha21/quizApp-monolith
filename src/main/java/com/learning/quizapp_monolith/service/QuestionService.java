package com.learning.quizapp_monolith.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.quizapp_monolith.model.Question;
import com.learning.quizapp_monolith.repo.QuestionDao;

@Service
public class QuestionService {
	@Autowired
	QuestionDao dao;
	public ResponseEntity<List<Question>> getAllQuestion() {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(dao.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

	}
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity<>(dao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		//System.out.println("Question ID: " + question.getId());
		try {
		 dao.save(question);
		 return new ResponseEntity<>("Success",HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Try again",HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> deleteQuestion(Integer id) {
        try {
            if (!dao.existsById(id)) {
                return new ResponseEntity<>("Question not found.", HttpStatus.NOT_FOUND);
            }
            dao.deleteById(id);
            return new ResponseEntity<>("Question deleted successfully.", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete question.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	 public ResponseEntity<String> updateQuestion(Question question) {
	        try {
	            Optional<Question> existingQuestion = dao.findById(question.getId());
	            if (existingQuestion.isEmpty()) {
	                return new ResponseEntity<>("Question not found.", HttpStatus.NOT_FOUND);
	            }
	            dao.save(question);
	            return new ResponseEntity<>("Question updated successfully.", HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return new ResponseEntity<>("Failed to update question.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	 }
}
