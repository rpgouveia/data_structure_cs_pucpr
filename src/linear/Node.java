package linear;

public class Node<E> {
    /* attributes */
    private E element;
    private Node<E> next;

    /* constructor */
    public Node(E element) {
        this.element = element;
        this.next = null;
    }

    /* getters and setters */
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
