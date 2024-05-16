package com.categoryservice.Exception;

@SuppressWarnings("serial")
public class CategoryFoundException extends Exception{

	public CategoryFoundException() {
		super("Category with this CategoryId is already present in DB !! Try with another one.");
	}
	
	public CategoryFoundException(String msg)
	{
		super(msg);
	}
}
