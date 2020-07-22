package com.wipro.eb.exception;

public class InvalidReadingException extends Exception {
	public String toString()
	{
		return "Invald";
	}
	
	public InvalidReadingException(String str)
	{
		super(str);
	}

}
