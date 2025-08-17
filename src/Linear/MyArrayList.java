package Linear;

// Create generic (https://www.w3schools.com/java/java_generics.asp)

// Implementation
public class MyArrayList<T> {
    // attributes
    private T[] data;
    private int capacity;
    private int size;

    // constructors
    @SuppressWarnings("unchecked") // Type safety: Unchecked cast from Object[] to T[]
    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity can not be negative: " + capacity);
        }
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity]; // Typecast Object[] to T[]
        this.size = 0;
    }

    public MyArrayList() {
        this(10); // default capacity
    }

    // helper methods
    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // methods
    @Override
    public String toString() {
        return String.format(
            "MyArrayList[capacity=%d, size=%d, data=array of length %d]", 
            capacity, size, data.length
        );
    }

    // private <E> void add(E e) {
    //     // todo
    // }

}

