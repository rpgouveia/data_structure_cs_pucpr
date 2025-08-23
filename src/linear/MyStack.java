package linear;

public class MyStack<T> {
    /* attributes */
    private MyNode top;
    private int size;

    /* constructor */
    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    /* helper methods */
    public boolean isEmpty() {
        return size == 0;
    }

    /* methods for debugging */
    // method to check MyArrayList construction
    @Override
    public String toString() {
        return String.format("MyStack[size=%d]", size);
    }



    /* main methods */
    public void push (T element) {
        MyNode node = new MyNode(element);
        if (top != null) {
            node.next = top;
        }
        top = node;
        size += 1;
    }
}
