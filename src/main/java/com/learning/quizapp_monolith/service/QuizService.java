package com.learning.quizapp_monolith.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.learning.quizapp_monolith.model.Question;
import com.learning.quizapp_monolith.model.QuestionWrapper;
import com.learning.quizapp_monolith.model.Quiz;
import com.learning.quizapp_monolith.model.Response;
import com.learning.quizapp_monolith.repo.QuestionDao;
import com.learning.quizapp_monolith.repo.QuizDao;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		List<Question> questions = questionDao.generateRandomQuestionsByCategory(category, numQ);
		
		quiz.setTitle(title);
		quiz.setQuestion(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id); 
		List<Question> questionsFromDb = quiz.get().getQuestion();
		List<QuestionWrapper> questionsForUser = new ArrayList<QuestionWrapper>();
		for(Question q: questionsFromDb) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			questionsForUser.add(qw);		
			}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questions = quiz.get().getQuestion();
		int right = 0;
		int i=0;
		for(Response response: responses) {
			if(response.getResponses().equals(questions.get(i).getAnswer()))
				right++;
		
		i++;
		}
		return new ResponseEntity<>(right, HttpStatus.OK);	
			
}

}
