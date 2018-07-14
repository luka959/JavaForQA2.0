package com.company;

public class IllegalOperationException extends Exception {

    public IllegalOperationException() {
        super("Недопустимое значение операции");
    }
}
