package ru.dmc3105.annotation;

import ru.dmc3105.domain.user.DomainModel;
import ru.dmc3105.domain.user.User;

public class Program {
    public static void main() {
        User user = new User("a", 1);
        var userClass = user.getClass();
        DomainModel annotation = userClass.getAnnotation(DomainModel.class);

        IO.println(annotation.value());
    }
}
