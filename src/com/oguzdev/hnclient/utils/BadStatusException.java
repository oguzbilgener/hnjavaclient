package com.oguzdev.hnclient.utils;

public class BadStatusException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int statusCode;
	
	public BadStatusException(int code)
	{
		statusCode = code;
	}
	public int getStatusCode()
	{
		return statusCode;
	}
}
