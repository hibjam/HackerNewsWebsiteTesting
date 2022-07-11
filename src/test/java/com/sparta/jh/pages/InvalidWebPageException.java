package com.sparta.jh.pages;

public class InvalidWebPageException extends Exception {
    private final String message;

    public InvalidWebPageException (String message){
        this.message = message;
    }
    @Override
    public String getMessage() {return message;}
}
