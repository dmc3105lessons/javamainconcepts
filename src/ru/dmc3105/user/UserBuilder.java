package ru.dmc3105.user;

public class UserBuilder {
    private String name;
    private Integer age;

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public User build() {
        return new User(name, age);
    }
}