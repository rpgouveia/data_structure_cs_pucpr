import Linear.MyArrayList;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== MyArrayList Test ===");
        
        // Basic constructor tests
        MyArrayList<String> list1 = new MyArrayList<>(5);
        MyArrayList<String> list2 = new MyArrayList<>();
        MyArrayList<String> list3 = new MyArrayList<>(0);
        
        System.out.println("Constructors:");
        System.out.println("Capacity 5: " + list1);
        System.out.println("Default:    " + list2);
        System.out.println("Capacity 0: " + list3);
        System.out.println();
        
        // Add elements and test growth
        MyArrayList<String> list = new MyArrayList<>(2);
        System.out.println("=== Adding Elements (capacity=2) ===");
        System.out.println("Initial: " + list.toDetailedString());
        
        list.add("Java");
        System.out.println("Add Java: " + list.toDetailedString());
        
        list.add("Python");
        System.out.println("Add Python: " + list.toDetailedString());
        
        list.add("JavaScript");
        System.out.println("Add JS: " + list.toDetailedString());
        
        list.add("C++");
        list.add("Go");
        System.out.println("Add C++, Go: " + list.toDetailedString());
        
        // Test growth from zero
        System.out.println("\n=== Growth from Zero ===");
        MyArrayList<String> zeroList = new MyArrayList<>(0);
        System.out.println("Initial: " + zeroList.toDetailedString());
        
        zeroList.add("First");
        System.out.println("Add First: " + zeroList.toDetailedString());
        
        zeroList.add("Second");
        System.out.println("Add Second: " + zeroList.toDetailedString());
    }
}