package com.quizservice.Exception;

@SuppressWarnings("serial")
public class QuizFoundException extends Exception{


	public QuizFoundException() {
		super("Quiz with this QuizId is already present in DB !! Try with another one.");
	}
	
	public QuizFoundException(String msg)
	{
		super(msg);
	}

}
