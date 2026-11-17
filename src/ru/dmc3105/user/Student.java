package ru.dmc3105.user;

public class Student extends User {

    private int averageGrade;

    public Student(String name, Integer age,  int averageGrade) {
        if (name == null || age == null) {
            throw new NullPointerException();
        }
        super(name, age);
        Math.random();

        this.averageGrade = averageGrade;
    }
}