package com.wipro.eb.exception;

public class InvalidConnectionException extends Exception{

	public String toString()
	{
		return "Invald";
	}
	public InvalidConnectionException(String st)
	{
		super(st);
	}
}
