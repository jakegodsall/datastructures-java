package org.example.linkedlist;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E data; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node int the list

        public Node(E data) {
            this.data = data;
            this.next = null;
        }

        public E getData() { return this.data; }

        public Node<E> getNext() { return this.next; }

        public void setData(E data) { this.data = data; }

        public void setNext(Node<E> next) { this.next = next; }
    }



}
