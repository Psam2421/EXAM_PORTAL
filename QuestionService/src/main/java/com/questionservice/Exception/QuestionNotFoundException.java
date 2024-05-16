package com.questionservice.Exception;

public class QuestionNotFoundException extends Exception{

	public QuestionNotFoundException() {
		super("Question with this QuestionId not found in database !!");
	}
	
	public QuestionNotFoundException(String msg)
	{
		super(msg);
	}
}
