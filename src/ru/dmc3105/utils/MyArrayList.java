package ru.dmc3105.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements Collection<T> {

    private static final int INITIAL_CAPACITY = 8;
    public static final int GROWTH_FACTOR = 2;

    private int size = 0;
    private Object[] data = new Object[INITIAL_CAPACITY];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (java.util.Objects.equals(data[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    @Override
    public boolean add(T element) {
        if (size == data.length) {
            reallocation();
        }

        data[size++] = element;
        return true;
    }

    private void reallocation() {
        Object[] newData = new Object[data.length * GROWTH_FACTOR];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (java.util.Objects.equals(data[i], o)) {
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    private void removeAt(int index) {
        int elementsToMove = size - index - 1;

        System.arraycopy(
                data, index + 1,
                data, index,
                elementsToMove
        );

        data[--size] = null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;

        for (T element : c) {
            add(element);
            modified = true;
        }

        return modified;
    }

    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; ) {
            if (!c.contains(data[i])) {
                removeAt(i);
                modified = true;
            } else {
                i++;
            }
        }

        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;

        for (int i = 0; i < size; ) {
            if (c.contains(data[i])) {
                removeAt(i);
                modified = true;
            } else {
                i++;
            }
        }

        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            return (E[]) Arrays.copyOf(data, size, a.getClass());
        }

        System.arraycopy(data, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }

    private class MyArrayListIterator implements Iterator<T> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return (T) data[currentIndex++];
        }
    }
}