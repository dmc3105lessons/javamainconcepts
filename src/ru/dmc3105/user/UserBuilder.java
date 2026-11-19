package ru.dmc3105.user;

public class UserBuilder {
    private String name;
    private Integer age;
    private Integer id;

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder age(Integer age) {
        this.age = age;
        return this;
    }

    public UserBuilder id(int id) {
        this.id = id;
        return this;
    }

    public User build() {
        if (id != null) {
            return new User(id, name, age);
        }
        return new User(name, age);
    }
}