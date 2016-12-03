package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    protected Object[] Stack;
    protected int Pos;

    public ArrayStack() {
        Stack = new Object[1];
        Pos = 0;
    }

    private void resizeArray(int newSize){
        Object[] tmp = new Object[newSize];
        System.arraycopy(Stack,0,tmp,0,Pos);
        Stack = tmp;
    }

    @Override
    public T push(T item) {
        if (Pos==Stack.length)
            resizeArray(Stack.length*2);
        Stack[Pos++] = item;
        return item;
    }

    @Override
    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();
        T item = (T)(Stack[--Pos]);
        if (Pos < Stack.length/4)
            resizeArray(Stack.length/2);
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return ((T)(Stack[Pos-1]));
    }

    @Override
    public boolean isEmpty() {
        return (Pos == 0);
    }

    @Override
    public long getSize() {
        return Pos;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int id = 0;
            @Override
            public boolean hasNext() {
                return (id<Pos);
            }

            @Override
            public T next() {
                return (T)(Stack[id++]);
            }
        };
    }
}
