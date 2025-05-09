package com.learning.quizapp_monolith.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Response {
	private Integer id;
	private String responses;
}
