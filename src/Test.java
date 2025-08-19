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
        
        // Test add(index, element)
        System.out.println("\n=== Testing add(index, element) ===");
        
        MyArrayList<String> indexList = new MyArrayList<>(3);
        
        // Add elements at the end first
        indexList.add("A");
        indexList.add("C");
        indexList.add("E");
        System.out.println("Initial list: " + indexList.toDetailedString());
        
        // Insert at beginning (index 0)
        indexList.add(0, "START");
        System.out.println("Add 'START' at index 0: " + indexList.toDetailedString());
        
        // Insert in the middle (index 2)
        indexList.add(2, "B");
        System.out.println("Add 'B' at index 2: " + indexList.toDetailedString());
        
        // Insert at the end (equivalent to add(element))
        indexList.add(indexList.size(), "END");
        System.out.println("Add 'END' at end: " + indexList.toDetailedString());
        
        // Insert in middle again
        indexList.add(4, "D");
        System.out.println("Add 'D' at index 4: " + indexList.toDetailedString());
        
        System.out.println("\n=== Edge Cases ===");
        
        // Test with empty list
        MyArrayList<Integer> emptyList = new MyArrayList<>(2);
        System.out.println("Empty list: " + emptyList.toDetailedString());
        
        emptyList.add(0, 100); // Insert at beginning of empty list
        System.out.println("Add 100 at index 0: " + emptyList.toDetailedString());
        
        emptyList.add(1, 200); // Insert at end
        System.out.println("Add 200 at index 1: " + emptyList.toDetailedString());
        
        emptyList.add(1, 150); // Insert in middle
        System.out.println("Add 150 at index 1: " + emptyList.toDetailedString());
        
        System.out.println("\n=== Error Cases ===");
        
        // Test invalid indices
        try {
            indexList.add(-1, "INVALID");
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index -1: " + error.getMessage());
        }
        
        try {
            indexList.add(indexList.size() + 1, "INVALID");
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index " + (indexList.size() + 1) + ": " + error.getMessage());
        }
        
        System.out.println("\nFinal state: " + indexList.toDetailedString());
    }
}