package com.questionservice.Exception;

@SuppressWarnings("serial")
public class QuestionAlreadyExistException extends Exception{

	public QuestionAlreadyExistException() {
		super("Question with this QuestionId is already present in DB !! Try with another one.");
	}
	
	public QuestionAlreadyExistException(String msg)
	{
		super(msg);
	}


}
