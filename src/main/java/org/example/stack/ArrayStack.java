package org.example.stack;

public class ArrayStack<E> implements Stack<E> {
    public static int DEFAULT_CAPACITY = 1000; // default array capacity
    private E[] data; // generic array used for storage
    private int t = -1; // index of the top element in the stack

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return (t == -1);
    }

    @Override
    public void push(E e) {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E top = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return top;
    }
}
