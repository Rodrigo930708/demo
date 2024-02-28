package com.demo.infrastructure.rest.exceptions;

public class ParametersException extends RuntimeException{

    private static final long serialVersionUID = 1L;

	public ParametersException() {

        super("Invalid Parameters");
    }
}
