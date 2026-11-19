package ru.dmc3105.service;

public record RegisterUserCommand(
        String name,
        Integer age
) {
    public static RegisterUserCommand of(String name, Integer age)
    {
        return new RegisterUserCommand(name, age);
    }
}
