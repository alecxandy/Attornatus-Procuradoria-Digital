package com.alexandre.gerenciamento.de.pessoas.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
