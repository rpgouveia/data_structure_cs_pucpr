package linear;

public class MyStack<T> {
    /* attributes */
    private Node<T> top;    // reference to the top node
    private int size;       // current size of the stack

    /* constructor */
    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    /* helper methods */
    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    /* methods for debugging */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "MyStack[empty]";
        }
        StringBuilder sb = new StringBuilder("MyStack[size=" + size + ", elements=");
        Node<T> current = top;
        while (current != null) {
            sb.append(current.getElement());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public void printElements() {
        System.out.print("Elements in stack (top to bottom): ");
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Node<T> current = top;
        while (current != null) {
            System.out.print(current.getElement());
            if (current.getNext() != null) {
                System.out.print(" -> ");
            }
            current = current.getNext();
        }
        System.out.println();
    }

    /* main methods */
    public void push (T element) {
        Node<T> newNode = new Node<>(element);
        newNode.setNext(top);
        top = newNode;
        size += 1;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T element = top.getElement();
        top = top.getNext();
        size--;
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getElement();
    }
}
