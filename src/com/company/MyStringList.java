package com.company;

import com.company.Exceptions.EmptyListException;
import com.company.Exceptions.IncorrectItemException;

public class MyStringList implements StringList{

    private String[] arr = new String[10];
    private int size = 0;

    @Override
    public String add(String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if (size == arr.length) {
            expand();
            }
        return arr[size++] = item;
    }

    @Override
    public String add(int index, String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if (size == arr.length) {
            expand();
        }
        if((arr[index] == null && arr[index-1] == null) || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == size) {
            arr[index] = item;
        } else {
            for (int i = size; i > index; i--) {
                String s = arr[i-1];
                arr[i] = s;
            }
        }
        size++;
        return arr[index] = item;
    }

    @Override
    public String set(int index, String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        if((arr[index] == null && arr[index-1] == null) || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index == size) {
            size++;
        }
        return arr[index] = item;
    }

    @Override
    public String remove(String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(item)) {
                if(i == size-1) {
                    arr[i] = null;
                } else {
                    for (int j = i; j < size-1; j++) {
                        String s = arr[j+1];
                        arr[j+1] = null;
                        arr[j] = s;
                    }
                    size--;
                    return item;
                }
            }

        }
        throw new IncorrectItemException();
    }

    @Override
    public String remove(int index) {
        if(arr[index] == null || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i;
        for (i = index; i < size-1; i++) {
            String s = arr[i+1];
            arr[i+1] = null;
            arr[i] = s;
        }
        size--;
        return arr[i];

    }

    @Override
    public boolean contains(String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if(arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(String item) {
        if(item == null) {
            throw new NullPointerException();
        }
        for (int i = size-1; i >= 0; i--) {
            if(arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(otherList == null) {
            throw new IncorrectItemException();
        }
        if(size != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!arr[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(size != 0 ) {
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size=0;
    }

    @Override
    public String[] toArray() {
        if(size == 0) {
            throw new EmptyListException("Пустой массив");
        }
        String[] newArr = new String[size];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;

    }

    private void expand() {
        String[] newArr = new String[(int) (size * 1.5)];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }
}
