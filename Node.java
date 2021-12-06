package p2;

public class Node<E> {

    private final E element;
    private Node<E> next;

    public Node(E element, Node<E> next) {

        this.element = element;
        this.next = next;
    }

    public Node(E element) {

        this(element, null);

    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

}
