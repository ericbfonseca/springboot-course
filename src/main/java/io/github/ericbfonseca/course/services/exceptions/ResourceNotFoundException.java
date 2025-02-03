package io.github.ericbfonseca.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. Id " + id); // Mensagem padrão da exceção personalizada
	}
}
