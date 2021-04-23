package io.github.davidrodrigues.exception;

public class SenhaInvalidaException extends RuntimeException {

    public SenhaInvalidaException() {
    }

    public SenhaInvalidaException(String message) {
        super("Senha inválida.");
    }

}
