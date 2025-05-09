package com.learning.quizapp_monolith.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String category;
	private String difficultyLevel;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
}
