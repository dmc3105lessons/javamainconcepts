package ru.dmc3105.generics;

public class PetriDish<T extends Bacteria<T>> {
    private T bacteria;

    public PetriDish(T bacteria) {
        this.bacteria = bacteria;
    }

    public void push(T bacteria) {
        this.bacteria = bacteria;
    }

    public T pull() {
        return this.bacteria;
    }
}