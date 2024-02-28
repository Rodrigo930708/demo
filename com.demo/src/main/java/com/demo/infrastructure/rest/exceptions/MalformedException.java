package com.demo.infrastructure.rest.exceptions;

public class MalformedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MalformedException() {

        super("Malformeed date");
    }
}
