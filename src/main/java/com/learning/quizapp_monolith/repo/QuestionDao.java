package com.learning.quizapp_monolith.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.learning.quizapp_monolith.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {
	
	  List<Question> findByCategory(String category);

	  @Query(value ="SELECT TOP (?2) * FROM questions q WHERE q.category = ?1 ORDER BY NEWID()", nativeQuery = true)
	  List<Question> generateRandomQuestionsByCategory(String category, int numQ);


}
