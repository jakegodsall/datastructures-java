package org.example.linkedlist;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private static class Node<E> {
        private E value; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node int the list

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        public E getData() { return this.value; }

        public Node<E> getNext() { return this.next; }

        public void setData(E value) { this.value = value; }

        public void setNext(Node<E> next) { this.next = next; }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() { }

    @Override
    public int size() { return this.size; }

    @Override
    public boolean isEmpty() { return size == 0; }

    @Override
    public E first() {
        if (isEmpty()) return null;
        return head.getData();
    }

    @Override
    public E last() {
        if (isEmpty()) return null;
        return tail.getData();
    }

    @Override
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node with the given value
        newNode.setNext(head); // Set the `next` of the new node to point to the current head
        head = newNode; // Set the head to the new node
        if (size == 0) // If the list is empty, then update the tail to be the new node too
            tail = head;
        size++; // Increase the size of the linked list
    }

    @Override
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node with the given value
        if (isEmpty()) // If the list is empty, set the head as the new node
            head = newNode;
        else // Otherwise, set the `next` of the tail to point to the new node
            tail.setNext(newNode);
        tail = newNode; // Set the tail to point to the new node
        size++; // Increase the size of the linked list
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) return null; // if the list is empty there is nothing to remove
        E data = head.getData();
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();

        }
        size--;
        return data;
    }

    @Override
    public E removeLast() {
        if (size == 0) return null; // if the list is empty there is nothing to remove
        if (size == 1) {
            E data = head.getData();
            head = null;
            tail = null;
            size--;
            return data;
        } else {
            Node<E> temp = head;
            Node<E> delay = head;
            while (temp.next != null) { // loop until reaching the penultimate element
                delay = temp;
                temp = temp.next;
            }
            delay.next = null;
            tail = delay; // update the tail reference
            E data = temp.getData();
            size--;
            return data;
        }
    }

}
