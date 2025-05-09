package com.learning.quizapp_monolith.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.quizapp_monolith.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

}
