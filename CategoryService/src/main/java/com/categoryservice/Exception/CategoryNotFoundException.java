package com.categoryservice.Exception;

public class CategoryNotFoundException extends Exception{

	public CategoryNotFoundException() {
		super("Category with this CategoryId not found in database !!");
	}
	
	public CategoryNotFoundException(String msg)
	{
		super(msg);
	}
}
