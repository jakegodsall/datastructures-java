package org.example.linkedlist;

public class CircularlyLinkedList<E> implements LinkedList<E> {

    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return tail.getNext().getValue();
    }

    @Override
    public E last() { // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return tail.getValue();
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            tail = newNode;
            tail.setNext(tail);
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
        size++;
    }

    @Override
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }

    @Override
    public E removeFirst() {
        // size == 0 case
        if (isEmpty()) return null;


        Node<E> head = tail.getNext();
        if (head == tail) { // size == 1 case
            tail = null;
        } else { // size > 1 case
            tail.setNext(head.getNext());
        }
        size--;
        return head.getValue();
    }

    @Override
    public E removeLast() {
        // size == 0 case
        if (isEmpty()) return null;

        if (size == 1) { // size == 1 case
            E value = tail.getValue();
            tail = null;
            size--;
            return value;

        } else { // size > 1 case
            Node<E> secondLast = tail.getNext();
            E value = tail.getValue();

            while (secondLast.getNext() != tail) {
                secondLast = secondLast.getNext();
            }
            secondLast.setNext(tail.getNext());
            tail = secondLast;

            size--;
            return value;
        }
    }
}
