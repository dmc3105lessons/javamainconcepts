package ru.dmc3105.generics;

import java.util.List;

public abstract class Bacteria<T extends Bacteria<T>> implements Divisible<T> {
    private int size;

    public Bacteria(int size) {
        this.size = size;
    }

    public Bacteria(Bacteria<T> bacteria) {
        this.size = bacteria.size;
    }

    public abstract T createCopy();

    @SuppressWarnings("unchecked")
    @Override
    public List<T> divide() {
        return List.of((T) this, createCopy());
    }

    public int getSize() {
        return size;
    }

    public Bacteria<T> setSize(int size) {
        this.size = size;
        return this;
    }
}
