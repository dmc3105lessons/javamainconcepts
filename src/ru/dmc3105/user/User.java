package ru.dmc3105.user;

import ru.dmc3105.Verifiable;

import java.util.List;
import java.util.Optional;

public class User implements Verifiable {
    private static int lastId = 0;

    private final int id;
    private String name;
    private Integer age;
    private List<NameChangedHandler> nameChangedHandlers;

    public User(String name, Integer age) {
        this(lastId++, name, age);
    }

    User(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public static User unknown() {
        return User.withName("unknown");
    }

    public static User withName(String name) {
        return User.withPersonalData(name, null);
    }

    public static User withPersonalData(String name, Integer age) {
        return new User(name, age);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        nameChangedHandlers.forEach(h -> h.onNameChanged(oldName, name));
    }

    public Optional<Integer> getAge() {
        return Optional.ofNullable(age);
    }

    /**
     *
     * @param age - возраст (nullable)
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public void addNameChangedHandler(NameChangedHandler nameChangedHandler) {
        nameChangedHandlers.add(nameChangedHandler);
    }

    public static UserBuilder builder() { return new UserBuilder(); }
}