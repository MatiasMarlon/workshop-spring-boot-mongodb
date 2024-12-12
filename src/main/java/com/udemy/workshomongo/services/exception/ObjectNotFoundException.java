package com.udemy.workshomongo.services.exception;
// Exceção personalizada caso seja feita uma busca por Id com o mesmo inexistente.
public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public  ObjectNotFoundException (String msg) {
		super(msg);
	}
}
