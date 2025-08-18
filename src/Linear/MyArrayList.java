package Linear;

// Create generic (https://www.w3schools.com/java/java_generics.asp)

// Implementation
public class MyArrayList<T> {
    // attributes
    private T[] data;       // array to store elements
    private int capacity;   // maximum number of elements
    private int size;       // current number of elements

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

    public boolean isFull() {
        return size >= capacity;
    }

    @SuppressWarnings("unchecked")
    private void increaseCapacity() {
        int newCapacity;
        if (capacity == 0) {
            newCapacity = 1; // Start with a capacity of 1 if current is 0
        } else {
            newCapacity = capacity * 2; // Double the capacity
        }

        System.out.println("Increasing array capacity from " + capacity + " to " + newCapacity);

        T[] newData = (T[]) new Object[newCapacity];

        // Copy elements to the new array
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        // Update the reference to the new array and the capacity
        data = newData;
        capacity = newCapacity;
    }

    // method to debug MyArrayList construction
    @Override
    public String toString() {
        return String.format(
            "MyArrayList[capacity=%d, size=%d, data=array of length %d]", 
            capacity, size, data.length
        );
    }

    // method to show elements
    public String toElementsString() {
        if (isEmpty()) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }

    // method to show detailed information
    public String toDetailedString() {
        return String.format(
            "MyArrayList[capacity=%d, size=%d] = %s", 
            capacity, size, toElementsString()
        );
    }


    // main methods
    public void add(T element) {
        if (size >= capacity) {
            increaseCapacity();
        }
        data[size] = element;
        size++;
    }

}

