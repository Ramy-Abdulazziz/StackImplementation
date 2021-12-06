package p2;

import java.util.NoSuchElementException;

public class SinglyLinkedStack<T> implements Stack<T> {

    private final SinglyLinkedList<T> stack;

    public SinglyLinkedStack() {

        this.stack = new SinglyLinkedList<T>();
    }

    public SinglyLinkedStack(T element) {

        this.stack = new SinglyLinkedList<T>(element);
    }

    public SinglyLinkedStack(T... elems) {

        this.stack = new SinglyLinkedList<T>(elems);
    }

    @Override
    public int size() {

        return stack.size();
    }

    @Override
    public void push(T elem) {

        stack.add(elem);
    }

    @Override
    public boolean isEmpty() {

        return stack.size() == 0;
    }

    @Override
    public T peek() {

        return (stack.size() == 0) ? null : stack.getFirst().getElement();
    }

    @Override
    public T pop() throws NoSuchElementException {

        T removed = stack.getFirst().getElement();
        stack.remove(0);

        return removed;
    }

    public String toString() {

        return stack.toString();
    }

}
