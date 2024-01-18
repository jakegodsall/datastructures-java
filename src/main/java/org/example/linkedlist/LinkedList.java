package org.example.linkedlist;

public interface LinkedList<E> {

    /**
     * Returns the number of elements in the linked list.
     * @return number of elements in the list
     */
    int size();

    /**
     * Tests whether the linked list is empty.
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Accesses the element at the front of the linked list
     * @return the element at the front of the list (or null if empty)
     */
    E first();

    /**
     * Accesses the element at the end of the linked list.
     * @return the element at the end of the list (or null if empty)
     */
    E last();

    /**
     * Inserts an element to the front of the linked list.
     * @param e the element to be inserted
     */
    void addFirst(E e);

    /**
     * Inserts an element at the end of the linked list.
     * @param e the element to be inserted
     */
    void addLast(E e);

    /**
     * Removes the first element from the linked list.
     * @return the removed element (or null if empty)
     */
    E removeFirst();

    /**
     * Removes the last element from the linked list.
     * @return the removed element (or null if empty)
     */
    E removeLast();

}
