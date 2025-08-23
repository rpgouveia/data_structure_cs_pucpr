package linear;

public class MyNode <E> {
    /* attributes */
    private E element;
    public MyNode<E> next;

    /* constructor */
    public MyNode(E element) {
        this.element = element;
        this.next = null;
    }
}
