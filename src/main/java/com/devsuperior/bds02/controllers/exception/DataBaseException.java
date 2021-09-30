package com.devsuperior.bds02.controllers.exception;

public class DataBaseException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public DataBaseException(String msg) {
		super(msg);
	}

}
