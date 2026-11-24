package ru.dmc3105.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException() {
        this("СУПЕР ПУПЕР ОШИБКА ПРИЛОЖЕНИЯ");
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
