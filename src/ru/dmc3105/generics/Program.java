package ru.dmc3105.generics;

import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void copyFromTo(List<? extends Integer> from, List<? super Integer> to)
    {
        for (Integer i : from) {
            to.add(i);
        }
    }

    @SuppressWarnings("rawtypes")
    static void main() {
        Salmonella salmonella = new Salmonella(100);
        Helicobacter helicobacter = new Helicobacter(10);

        Bacteria someBacteria = salmonella;

//        PetriDish<Salmonella> salmonellaPetriDish = new PetriDish<>(salmonella);
//        PetriDish<Bacteria> bacteriaPetriDish = salmonellaPetriDish;


        List<Integer> numbersSource = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Object> numbersDestination = new ArrayList<>();

        copyFromTo(numbersSource, numbersDestination);

        // как нужно переносить отношения наследование Salmonella от Bacteria
        // на более сложные/составные типы. Например - PetriDish<Salmonella> и PetriDish<Bacteria>
    }
}
