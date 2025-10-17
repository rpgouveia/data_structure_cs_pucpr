package non_linear;

public class Node<T> {
    // attributes
    private T element;
    private Node<T> right;
    private Node<T> left;

    // constructor
    public Node(T element) {
        this.element = element;
        this.right = null;
        this.left = null;
    }
}
