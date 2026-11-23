package ru.dmc3105.generics;

public class Helicobacter extends Bacteria<Helicobacter> {

    public Helicobacter(int size) {
        super(size);
    }

    public Helicobacter(Bacteria<Helicobacter> bacteria) {
        super(bacteria);
    }

    @Override
    public Helicobacter createCopy() {
        return new Helicobacter(this);
    }
}
