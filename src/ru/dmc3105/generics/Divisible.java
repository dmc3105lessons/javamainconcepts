package ru.dmc3105.generics;

import java.util.List;

public interface Divisible<T extends Divisible<T>> {
    List<T> divide();
}
