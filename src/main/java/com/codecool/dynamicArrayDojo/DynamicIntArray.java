package com.codecool.dynamicArrayDojo;


import java.util.Arrays;
import java.util.StringJoiner;

public class DynamicIntArray {

    int[] data;
    int size;

    public DynamicIntArray() {
        data = new int[8];
        size = 0;
    }

    public DynamicIntArray(int capacity) {
        data = new int[capacity];
        this.size = 0;
    }

    public void add(int value){
        resizeIfFull();
        data[size] = value;
        size++;
    }

    public void insert(int index, int value){
        if(index>=size){
            add(value);
        }else {
            resizeIfFull();
            for (int from = size - 1; from >= index; from--) {
                data[from + 1] = data[from];
            }
            data[index] = value;
            size++;
        }
    }

    private void resizeIfFull() {
        if(size >= data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    public void remove(int index){
        if(index >= size || index<0)
            throw new ArrayIndexOutOfBoundsException();
        else{
            for(int from=index; from<size-1; from++){
                data[from] = data[from+1];
            }
        }
        size--;

    }

    public String toString() {
        StringJoiner sj = new StringJoiner(" ");
        sj.add("");
        for(int i = 0 ; i<size; i++){
            sj.add(String.valueOf(data[i]));

        }
        return sj.toString();
    }
}
