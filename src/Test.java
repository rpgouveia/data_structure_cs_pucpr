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
        
        // Test remove(index)
        System.out.println("\n=== Testing remove(index) ===");
        
        MyArrayList<String> removeList = new MyArrayList<>(5);
        
        // Add some elements first
        removeList.add("A");
        removeList.add("B");
        removeList.add("C");
        removeList.add("D");
        removeList.add("E");
        System.out.println("Initial list: " + removeList.toDetailedString());
        
        // Remove from middle
        String removed1 = removeList.remove(2);
        System.out.println("Removed '" + removed1 + "' from index 2: " + removeList.toDetailedString());
        
        // Remove from beginning
        String removed2 = removeList.remove(0);
        System.out.println("Removed '" + removed2 + "' from index 0: " + removeList.toDetailedString());
        
        // Remove from end
        String removed3 = removeList.remove(removeList.size() - 1);
        System.out.println("Removed '" + removed3 + "' from end: " + removeList.toDetailedString());
        
        // Remove until empty
        String removed4 = removeList.remove(0);
        String removed5 = removeList.remove(0);
        System.out.println("Removed '" + removed4 + "' and '" + removed5 + "': " + removeList.toDetailedString());
        
        System.out.println("\n=== Remove Error Cases ===");
        
        // Test remove from empty list
        try {
            removeList.remove(0);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error removing from empty list: " + error.getMessage());
        }
        
        // Add one element and test invalid indices
        removeList.add("ONLY");
        System.out.println("List with one element: " + removeList.toDetailedString());
        
        try {
            removeList.remove(-1);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index -1: " + error.getMessage());
        }
        
        try {
            removeList.remove(1);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index 1: " + error.getMessage());
        }
        
        // Remove the last element
        String lastRemoved = removeList.remove(0);
        System.out.println("Removed last element '" + lastRemoved + "': " + removeList.toDetailedString());
        
        // Test remove(Object)
        System.out.println("\n=== Testing remove(Object) ===");
        
        MyArrayList<String> objectRemoveList = new MyArrayList<>(6);
        
        // Add some elements with duplicates
        objectRemoveList.add("Java");
        objectRemoveList.add("Python");
        objectRemoveList.add("Java");
        objectRemoveList.add("C++");
        objectRemoveList.add("Python");
        objectRemoveList.add("Go");
        System.out.println("Initial list with duplicates: " + objectRemoveList.toDetailedString());
        
        // Remove first occurrence of "Java"
        boolean removedJava1 = objectRemoveList.remove("Java");
        System.out.println("Remove 'Java' (first occurrence) - Success: " + removedJava1);
        System.out.println("Result: " + objectRemoveList.toDetailedString());
        
        // Remove "C++"
        boolean removedCpp = objectRemoveList.remove("C++");
        System.out.println("Remove 'C++' - Success: " + removedCpp);
        System.out.println("Result: " + objectRemoveList.toDetailedString());
        
        // Try to remove non-existent element
        boolean removedRust = objectRemoveList.remove("Rust");
        System.out.println("Remove 'Rust' (doesn't exist) - Success: " + removedRust);
        System.out.println("Result: " + objectRemoveList.toDetailedString());
        
        // Remove remaining "Java" (second occurrence)
        boolean removedJava2 = objectRemoveList.remove("Java");
        System.out.println("Remove 'Java' (second occurrence) - Success: " + removedJava2);
        System.out.println("Result: " + objectRemoveList.toDetailedString());
        
        System.out.println("\n=== Testing remove(Object) with null ===");
        
        MyArrayList<String> nullTestList = new MyArrayList<>(4);
        nullTestList.add("A");
        nullTestList.add(null);
        nullTestList.add("B");
        nullTestList.add(null);
        System.out.println("List with nulls: " + nullTestList.toDetailedString());
        
        // Remove first null
        boolean removedFirstNull = nullTestList.remove(null);
        System.out.println("Remove null (first occurrence) - Success: " + removedFirstNull);
        System.out.println("Result: " + nullTestList.toDetailedString());
        
        // Remove second null
        boolean removedSecondNull = nullTestList.remove(null);
        System.out.println("Remove null (second occurrence) - Success: " + removedSecondNull);
        System.out.println("Result: " + nullTestList.toDetailedString());
        
        // Try to remove null when none exists
        boolean removedNonExistentNull = nullTestList.remove(null);
        System.out.println("Remove null (doesn't exist) - Success: " + removedNonExistentNull);
        System.out.println("Result: " + nullTestList.toDetailedString());
        
        System.out.println("\n=== Testing remove(Object) on empty list ===");
        
        MyArrayList<String> emptyRemoveList = new MyArrayList<>();
        boolean removedFromEmpty = emptyRemoveList.remove("anything");
        System.out.println("Remove from empty list - Success: " + removedFromEmpty);
        System.out.println("Empty list: " + emptyRemoveList.toDetailedString());
        
        // Test set(index, element)
        System.out.println("\n=== Testing set(index, element) ===");
        
        MyArrayList<String> setList = new MyArrayList<>(5);
        
        // Add some initial elements
        setList.add("Original1");
        setList.add("Original2");
        setList.add("Original3");
        setList.add("Original4");
        System.out.println("Initial list: " + setList.toDetailedString());
        
        // Set element at beginning
        String oldValue1 = setList.set(0, "New1");
        System.out.println("Set index 0 to 'New1', old value: '" + oldValue1 + "'");
        System.out.println("Result: " + setList.toDetailedString());
        
        // Set element in middle
        String oldValue2 = setList.set(2, "New3");
        System.out.println("Set index 2 to 'New3', old value: '" + oldValue2 + "'");
        System.out.println("Result: " + setList.toDetailedString());
        
        // Set element at end
        String oldValue3 = setList.set(setList.size() - 1, "NewLast");
        System.out.println("Set last index to 'NewLast', old value: '" + oldValue3 + "'");
        System.out.println("Result: " + setList.toDetailedString());
        
        // Set same element multiple times
        String oldValue4 = setList.set(1, "Updated");
        String oldValue5 = setList.set(1, "UpdatedAgain");
        System.out.println("Set index 1 twice: '" + oldValue4 + "' -> '" + oldValue5 + "'");
        System.out.println("Result: " + setList.toDetailedString());
        
        System.out.println("\n=== Testing set with different types ===");
        
        MyArrayList<Integer> numberList = new MyArrayList<>(3);
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        System.out.println("Number list: " + numberList.toDetailedString());
        
        Integer oldNumber = numberList.set(1, 999);
        System.out.println("Set index 1 to 999, old value: " + oldNumber);
        System.out.println("Result: " + numberList.toDetailedString());
        
        System.out.println("\n=== Testing set with null values ===");
        
        MyArrayList<String> nullSetList = new MyArrayList<>(3);
        nullSetList.add("A");
        nullSetList.add("B");
        nullSetList.add("C");
        System.out.println("Initial: " + nullSetList.toDetailedString());
        
        // Set to null
        String oldValueNull = nullSetList.set(1, null);
        System.out.println("Set index 1 to null, old value: '" + oldValueNull + "'");
        System.out.println("Result: " + nullSetList.toDetailedString());
        
        // Set null to something else
        String oldValueFromNull = nullSetList.set(1, "NotNull");
        System.out.println("Set index 1 from null to 'NotNull', old value: " + oldValueFromNull);
        System.out.println("Result: " + nullSetList.toDetailedString());
        
        System.out.println("\n=== Set Error Cases ===");
        
        // Test invalid indices
        try {
            setList.set(-1, "INVALID");
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index -1: " + error.getMessage());
        }
        
        try {
            setList.set(setList.size(), "INVALID");
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index " + setList.size() + ": " + error.getMessage());
        }
        
        // Test set on empty list
        MyArrayList<String> emptySetList = new MyArrayList<>();
        try {
            emptySetList.set(0, "INVALID");
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error setting on empty list: " + error.getMessage());
        }
        
        System.out.println("\nFinal set list state: " + setList.toDetailedString());
    }
}