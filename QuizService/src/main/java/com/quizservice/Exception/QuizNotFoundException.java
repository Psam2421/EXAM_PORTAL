package com.quizservice.Exception;

public class QuizNotFoundException extends Exception {
	
	public QuizNotFoundException() {
		super("Quiz with this title not found in database !!");
	}
	
	public QuizNotFoundException(String msg)
	{
		super(msg);
	}

}
