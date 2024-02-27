package com.demo.application.exception;

public class MalformedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MalformedException() {

        super("Malformeed date");
    }
}
