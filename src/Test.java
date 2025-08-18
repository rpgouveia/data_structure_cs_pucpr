import Linear.MyArrayList;

public class Test {
    public static void main(String[] args) {
        // Test: Constructor with specific capacity
        MyArrayList<String> list1 = new MyArrayList<>(5);
        System.out.println("List 1: " + list1);
        
        // Test: Constructor with default capacity
        MyArrayList<Integer> list2 = new MyArrayList<>();
        System.out.println("List 2: " + list2);

        // Test: Constructor with zero capacity (valid)
        MyArrayList<Double> list3 = new MyArrayList<>(0);
        System.out.println("List 3: " + list3);

        // Basic tests
        System.out.println("Is List 1 empty? " + list1.isEmpty());
        System.out.println("List 1 Capacity: " + list1.getCapacity());
        System.out.println("Current List Size 1: " + list1.getSize());
        System.out.println("List 2 Capacity: " + list2.getCapacity());
        System.out.println("Current List Size 2: " + list2.getSize());

        // Exception Test: (uncomment to test)
        // Exception in thread "main" java.lang.IllegalArgumentException: Capacity can not be negative: -1
        // MyArrayList<String> invalidList = new MyArrayList<>(-1);

        // Create list with capacity 3 for easy testing
        MyArrayList<String> list = new MyArrayList<>(3);
        
        System.out.println("Initial list: " + list);
        System.out.println("Is empty? " + list.isEmpty());
        System.out.println("Is full? " + list.isFull());
        System.out.println("Size: " + list.getSize());
        System.out.println();
        
        // Add first element
        list.add("Java");
        System.out.println("Structure: " + list);
        System.out.println("Elements: " + list.toElementsString());
        System.out.println("Detailed: " + list.toDetailedString());
        System.out.println();
        
        // Add second element
        list.add("Python");
        System.out.println("Structure: " + list);
        System.out.println("Elements: " + list.toElementsString());
        System.out.println();
        
        // Add third element (list will become full)
        list.add("JavaScript");
        System.out.println("Structure: " + list);
        System.out.println("Elements: " + list.toElementsString());
        System.out.println();
        
        // Add more elements to test automatic growth
        list.add("C++");
        System.out.println("After automatic growth:");
        System.out.println("Structure: " + list);
        System.out.println("Elements: " + list.toElementsString());
        System.out.println("Detailed: " + list.toDetailedString());
        System.out.println();
        
        // Add more elements to see it grow again
        list.add("Go");
        list.add("Rust");
        list.add("Kotlin");
        System.out.println("Final state:");
        System.out.println("Structure: " + list);
        System.out.println("Elements: " + list.toElementsString());
        
        // Test with list starting with capacity 0
        System.out.println("\n--- Test growth from capacity 0 ---");
        MyArrayList<String> zeroList = new MyArrayList<>(0);
        System.out.println("Initial structure: " + zeroList);
        
        zeroList.add("First");
        System.out.println("After first add - Structure: " + zeroList);
        System.out.println("Elements: " + zeroList.toElementsString());
        
        zeroList.add("Second");
        System.out.println("After second add - Detailed: " + zeroList.toDetailedString());
    }
}