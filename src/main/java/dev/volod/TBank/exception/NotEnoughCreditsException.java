package dev.volod.TBank.exception;

public class NotEnoughCreditsException extends RuntimeException{
    public NotEnoughCreditsException(String message) {
        super(message);
    }
}
