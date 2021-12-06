package p2;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private Node<T> cursor;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public SinglyLinkedList(T element) {

        this.first = new Node<T>(element);
        this.last = first;
        this.cursor = first;
    }

    @SafeVarargs
    public SinglyLinkedList(T... elems) {

        first = new Node<T>(elems[elems.length - 1]);

        cursor = first;
        size++;

        Node<T> previous = first;

        for (int i = elems.length - 2; i >= 0; i--) {

            Node<T> current = new Node<T>(elems[i]);
            previous.setNext(current);
            previous = current;
            size++;
        }

        moveCursorToIndex(size - 1);

        last = cursor;

    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void add(T elem, int index) throws NullPointerException {


            moveCursorToIndex(index - 1);

            Node<T> addedElem = new Node<T>(elem, this.cursor.getNext());
            this.cursor.setNext(addedElem);

            size++;


    }

    @Override
    public void add(T elem) {

        Node<T> addedElem = new Node<T>(elem, first);

        first = addedElem;
        size++;

    }

    @Override
    public T remove(int index) throws NullPointerException {

        T removed = null;


            if (index == 0) {

                moveCursorToIndex(index);
                if (size != 1)
                    first = cursor.getNext();
                else {
                    removed = (T) first;
                    first = null;
                    size = 0;
                    return removed;

                }

            } else if (index == size - 1) {

                moveCursorToIndex(size - 2);
                last = cursor;

            } else {

                moveCursorToIndex(index - 1);
            }

            removed = cursor.getElement();
            cursor.setNext(cursor.getNext().getNext());
            size--;

        return removed;
    }

    @Override
    public void remove(T elem) {

        if (!find(elem))
            throw new NoSuchElementException();
        else {

            int index = 0;
            moveCursorToIndex(index);

            while (cursor.getElement() != elem) {

                cursor = cursor.getNext();
                index++;
            }

            remove(index);

        }

    }

    @Override
    public boolean find(T elem) {

        if (size == 0)
            return false;

        moveCursorToIndex(0);

        for (int i = 0; i < size; i++) {

            if (cursor.getElement().equals(elem)) {

                return true;
            }

            cursor = cursor.getNext();

        }

        return false;
    }

    public void moveCursorToIndex(int index) {

        this.cursor = this.first;

        for (int i = 0; i < size; i++) {

            if (i != index)
                this.cursor = this.cursor.getNext();

            else if (i == index) {

                break;
            }

        }
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }


    public Node<T> getCursor() {
        return cursor;
    }

    public String toString() {

        if (size == 0)
            System.out.println("There are no elements in the list");
        moveCursorToIndex(0);

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < size; i++) {

            string.append(cursor.getElement().toString() + " ");
            cursor = cursor.getNext();
        }

        return string.toString();
    }

}
