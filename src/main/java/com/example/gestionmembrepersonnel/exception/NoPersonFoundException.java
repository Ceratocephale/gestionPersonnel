package com.example.gestionmembrepersonnel.exception;

public class NoPersonFoundException extends  RuntimeException{
    public NoPersonFoundException(Throwable cause) {
        super("The requested person was not found",cause);
    }

    public NoPersonFoundException() {
        super("The requested person was not found");
    }
}
