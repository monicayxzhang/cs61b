public class ArrayDeque<T> {
    private T[] items;
    private int firstind;
    private int size;
    private static int RFACTOR = 2;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        firstind = 0;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(int index) {
        return (firstind + index + items.length) % items.length;
    }

    private void resize(int capacity) {
        T[] newitems = (T[]) new Object[capacity];
        for (int i = 0; i < size; i += 1) {
            newitems[i] = items[getIndex(i)];
        }
        items = newitems;
        firstind = 0;
    }

    private void checkDouble() {
        if (size == items.length) {
            resize(items.length * RFACTOR);
        }
    }

    private void checkHalve() {
        if (items.length >= 16 && (float) size / items.length <= 0.25) {
            resize(items.length / 2);
        }
    }

    public void addFirst(T item) {
        checkDouble();
        firstind = getIndex(-1);
        items[firstind] = item;
        size = size + 1;
    }

    public void addLast(T item) {
        checkDouble();
        int lastind = getIndex(size);
        items[lastind] = item;
        size = size + 1;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T firstitem = items[firstind];
        items[firstind] = null;
        firstind = getIndex(1);
        size = size - 1;
        checkHalve();
        return firstitem;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        int lastind = getIndex(size - 1);
        T lastitem = items[lastind];
        items[lastind] = null;
        size = size - 1;
        checkHalve();
        return lastitem;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index > size - 1) {
            return null;
        }
        return items[getIndex(index)];
    }

    public void printDeque() {
        for (int i = 0; i < size; i += 1) {
            System.out.print(items[getIndex(i)] + " ");
        }
        System.out.println("");
    }
}