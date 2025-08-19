package Linear;

// ArrayList (https://www.w3schools.com/java/java_arraylist.asp)
// Create generic (https://www.w3schools.com/java/java_generics.asp)

// Implementation
public class MyArrayList<T> {
    /* attributes */
    private T[] data;       // array to store elements
    private int capacity;   // maximum number of elements
    private int size;       // current number of elements

    /* constructors */
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

    /* helper methods */
    public int getCapacity() {
        return capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= capacity;
    }

    // method for flexible index validation
    private void checkIndex(int index, boolean allowSizeIndex) {
        int maxIndex = allowSizeIndex ? size : size - 1;
        if (index < 0 || index > maxIndex) {
            String range = allowSizeIndex ? "0 to " + size : "0 to " + (size - 1);
            throw new IndexOutOfBoundsException("Index out of bounds: " + index + ". Valid range: " + range + ".");
        }
    }

    // method for standard index checking (most common case: 0 to size-1)
    private void checkIndex(int index) {
        checkIndex(index, false);
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

    /* methods for debugging */
    // method to check MyArrayList construction
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
        
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        
        for (int i = 0; i < size; i++) {
            stringBuilder.append(data[i]);
            if (i < size - 1) {
                stringBuilder.append(", ");
            }
        }
        
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    // method to show detailed information
    public String toDetailedString() {
        return String.format(
            "MyArrayList[capacity=%d, size=%d] = %s", 
            capacity, size, toElementsString()
        );
    }

    /* main methods */
    // method to add elements at the end of the list
    public void add(T element) {
        if (size >= capacity) {
            increaseCapacity();
        }
        data[size] = element;
        size++;
    }

    // method to add elements at a specific index
    public void add(int index, T element) {
        checkIndex(index, true); // Allow index == size for insertion at end

        if (size >= capacity) {
            increaseCapacity();
        }
        
        // Shift elements to the right
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = element;
        size++;
    }

    // method to remove elements at a specific index
    public T remove(int index) {
        checkIndex(index);
        
        // Store the element to be removed
        T removedElement = data[index];
        
        // Shift elements to the left
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null; // Clear the last element
        size--;
        return removedElement;
    }

    // method to remove the first occurrence of a specific object
    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            // Check if the current element matches the object to remove
            if (object == null ? data[i] == null : object.equals(data[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    // method to get the current size of the list
    public int size() {
        return size;
    }

    // method to set an element at a specific index
    public T set(int index, T element) {
        checkIndex(index);
        T oldValue = data[index];
        data[index] = element;
        return oldValue;
    }

    // method to get an element at a specific index
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    // method to find the index of an element
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            // Check if the current element matches the object
            if (object == null ? data[i] == null : object.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }
}