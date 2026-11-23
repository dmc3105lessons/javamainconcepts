package ru.dmc3105.generics;

public class Salmonella extends Bacteria<Salmonella> {

    public Salmonella(int size) {
        super(size);
    }

    public Salmonella(Bacteria<Salmonella> bacteria) {
        super(bacteria);
    }

    @Override
    public Salmonella createCopy() {
        return new Salmonella(this);
    }

    public <T extends Bacteria<T>> Bacteria<T> interatctaion(Bacteria<T> bacteria) {
        var midSize = (this.getSize() + bacteria.getSize()) / 2;
        bacteria.setSize(midSize);
        this.setSize(midSize);
        return bacteria;
    }
}
