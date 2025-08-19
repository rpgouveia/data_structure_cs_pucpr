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
        
        // Test get(index)
        System.out.println("\n=== Testing get(index) ===");
        
        MyArrayList<String> getList = new MyArrayList<>(5);
        
        // Add some elements first
        getList.add("First");
        getList.add("Second");
        getList.add("Third");
        getList.add("Fourth");
        System.out.println("Initial list: " + getList.toDetailedString());
        
        // Get elements from different positions
        String first = getList.get(0);
        String second = getList.get(1);
        String third = getList.get(2);
        String last = getList.get(getList.size() - 1);
        
        System.out.println("Get index 0: '" + first + "'");
        System.out.println("Get index 1: '" + second + "'");
        System.out.println("Get index 2: '" + third + "'");
        System.out.println("Get last index: '" + last + "'");
        
        // Verify list is unchanged after get operations
        System.out.println("List after gets (unchanged): " + getList.toDetailedString());
        
        System.out.println("\n=== Testing get with different types ===");
        
        MyArrayList<Integer> numberGetList = new MyArrayList<>(4);
        numberGetList.add(100);
        numberGetList.add(200);
        numberGetList.add(300);
        System.out.println("Number list: " + numberGetList.toDetailedString());
        
        Integer num1 = numberGetList.get(0);
        Integer num2 = numberGetList.get(1);
        Integer num3 = numberGetList.get(2);
        
        System.out.println("Numbers: " + num1 + ", " + num2 + ", " + num3);
        
        System.out.println("\n=== Testing get with null values ===");
        
        MyArrayList<String> nullGetList = new MyArrayList<>(3);
        nullGetList.add("NotNull");
        nullGetList.add(null);
        nullGetList.add("AlsoNotNull");
        System.out.println("List with null: " + nullGetList.toDetailedString());
        
        String notNull = nullGetList.get(0);
        String nullValue = nullGetList.get(1);
        String alsoNotNull = nullGetList.get(2);
        
        System.out.println("Get index 0: '" + notNull + "'");
        System.out.println("Get index 1 (null): " + nullValue);
        System.out.println("Get index 2: '" + alsoNotNull + "'");
        
        System.out.println("\n=== Testing get with single element ===");
        
        MyArrayList<String> singleList = new MyArrayList<>(1);
        singleList.add("OnlyOne");
        System.out.println("Single element list: " + singleList.toDetailedString());
        
        String onlyElement = singleList.get(0);
        System.out.println("Get only element: '" + onlyElement + "'");
        
        System.out.println("\n=== Get Error Cases ===");
        
        // Test invalid indices
        try {
            getList.get(-1);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index -1: " + error.getMessage());
        }
        
        try {
            getList.get(getList.size());
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index " + getList.size() + ": " + error.getMessage());
        }
        
        try {
            getList.get(100);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error for index 100: " + error.getMessage());
        }
        
        // Test get on empty list
        MyArrayList<String> emptyGetList = new MyArrayList<>();
        try {
            emptyGetList.get(0);
        } catch (IndexOutOfBoundsException error) {
            System.out.println("Caught expected error getting from empty list: " + error.getMessage());
        }
        
        System.out.println("\n=== Demonstrating get vs set ===");
        
        MyArrayList<String> demoList = new MyArrayList<>(3);
        demoList.add("A");
        demoList.add("B");
        demoList.add("C");
        System.out.println("Demo list: " + demoList.toDetailedString());
        
        // Get doesn't change the list
        String gotValue = demoList.get(1);
        System.out.println("Got value at index 1: '" + gotValue + "'");
        System.out.println("List after get: " + demoList.toDetailedString());
        
        // Set changes the list
        String oldValue = demoList.set(1, "CHANGED");
        System.out.println("Set index 1 to 'CHANGED', old value: '" + oldValue + "'");
        System.out.println("List after set: " + demoList.toDetailedString());
        
        // Get the changed value
        String newValue = demoList.get(1);
        System.out.println("Get new value at index 1: '" + newValue + "'");
        
        // Test indexOf(Object)
        System.out.println("\n=== Testing indexOf(Object) ===");
        
        MyArrayList<String> indexOfList = new MyArrayList<>(8);
        
        // Add some elements with duplicates
        indexOfList.add("Apple");
        indexOfList.add("Banana");
        indexOfList.add("Cherry");
        indexOfList.add("Banana");
        indexOfList.add("Date");
        indexOfList.add("Apple");
        System.out.println("List with duplicates: " + indexOfList.toDetailedString());
        
        // Find indices of existing elements
        int appleIndex = indexOfList.indexOf("Apple");
        int bananaIndex = indexOfList.indexOf("Banana");
        int cherryIndex = indexOfList.indexOf("Cherry");
        int dateIndex = indexOfList.indexOf("Date");
        
        System.out.println("Index of 'Apple' (first occurrence): " + appleIndex);
        System.out.println("Index of 'Banana' (first occurrence): " + bananaIndex);
        System.out.println("Index of 'Cherry': " + cherryIndex);
        System.out.println("Index of 'Date': " + dateIndex);
        
        // Try to find non-existent element
        int grapeIndex = indexOfList.indexOf("Grape");
        System.out.println("Index of 'Grape' (doesn't exist): " + grapeIndex);
        
        System.out.println("\n=== Testing indexOf with null values ===");
        
        MyArrayList<String> nullIndexList = new MyArrayList<>(5);
        nullIndexList.add("First");
        nullIndexList.add(null);
        nullIndexList.add("Third");
        nullIndexList.add(null);
        nullIndexList.add("Last");
        System.out.println("List with nulls: " + nullIndexList.toDetailedString());
        
        // Find indices including null
        int firstIndex = nullIndexList.indexOf("First");
        int nullIndex = nullIndexList.indexOf(null);
        int thirdIndex = nullIndexList.indexOf("Third");
        int lastIndex = nullIndexList.indexOf("Last");
        
        System.out.println("Index of 'First': " + firstIndex);
        System.out.println("Index of null (first occurrence): " + nullIndex);
        System.out.println("Index of 'Third': " + thirdIndex);
        System.out.println("Index of 'Last': " + lastIndex);
        
        System.out.println("\n=== Testing indexOf with different types ===");
        
        MyArrayList<Integer> numberIndexList = new MyArrayList<>(4);
        numberIndexList.add(100);
        numberIndexList.add(200);
        numberIndexList.add(300);
        numberIndexList.add(200);
        System.out.println("Number list: " + numberIndexList.toDetailedString());
        
        int index100 = numberIndexList.indexOf(100);
        int index200 = numberIndexList.indexOf(200); // First occurrence
        int index300 = numberIndexList.indexOf(300);
        int index400 = numberIndexList.indexOf(400); // Doesn't exist
        
        System.out.println("Index of 100: " + index100);
        System.out.println("Index of 200 (first occurrence): " + index200);
        System.out.println("Index of 300: " + index300);
        System.out.println("Index of 400 (doesn't exist): " + index400);
        
        System.out.println("\n=== Testing indexOf on empty list ===");
        
        MyArrayList<String> emptyIndexList = new MyArrayList<>();
        int indexInEmpty = emptyIndexList.indexOf("anything");
        System.out.println("Index of 'anything' in empty list: " + indexInEmpty);
        
        System.out.println("\n=== Testing indexOf with single element ===");
        
        MyArrayList<String> singleIndexList = new MyArrayList<>(1);
        singleIndexList.add("OnlyOne");
        System.out.println("Single element list: " + singleIndexList.toDetailedString());
        
        int onlyOneIndex = singleIndexList.indexOf("OnlyOne");
        int notFoundIndex = singleIndexList.indexOf("NotThere");
        
        System.out.println("Index of 'OnlyOne': " + onlyOneIndex);
        System.out.println("Index of 'NotThere': " + notFoundIndex);
        
        System.out.println("\n=== Demonstrating indexOf vs remove(Object) ===");
        
        MyArrayList<String> compareList = new MyArrayList<>(4);
        compareList.add("A");
        compareList.add("B");
        compareList.add("C");
        compareList.add("B");
        System.out.println("Demo list: " + compareList.toDetailedString());
        
        // indexOf finds first occurrence but doesn't modify list
        int foundIndex = compareList.indexOf("B");
        System.out.println("indexOf('B') returns: " + foundIndex);
        System.out.println("List after indexOf (unchanged): " + compareList.toDetailedString());
        
        // remove(Object) removes first occurrence and modifies list
        boolean removed = compareList.remove("B");
        System.out.println("remove('B') returns: " + removed);
        System.out.println("List after remove: " + compareList.toDetailedString());
        
        // indexOf again to see the remaining B moved to different index
        int newIndex = compareList.indexOf("B");
        System.out.println("indexOf('B') after removal: " + newIndex);
        
        // Test contains(Object)
        System.out.println("\n=== Testing contains(Object) ===");
        
        MyArrayList<String> containsList = new MyArrayList<>(6);
        
        // Add some elements
        containsList.add("Java");
        containsList.add("Python");
        containsList.add("JavaScript");
        containsList.add("C++");
        containsList.add("Go");
        System.out.println("Programming languages list: " + containsList.toDetailedString());
        
        // Check for existing elements
        boolean hasJava = containsList.contains("Java");
        boolean hasPython = containsList.contains("Python");
        boolean hasJavaScript = containsList.contains("JavaScript");
        boolean hasGo = containsList.contains("Go");
        
        System.out.println("Contains 'Java': " + hasJava);
        System.out.println("Contains 'Python': " + hasPython);
        System.out.println("Contains 'JavaScript': " + hasJavaScript);
        System.out.println("Contains 'Go': " + hasGo);
        
        // Check for non-existing elements
        boolean hasRust = containsList.contains("Rust");
        boolean hasKotlin = containsList.contains("Kotlin");
        boolean hasSwift = containsList.contains("Swift");
        
        System.out.println("Contains 'Rust': " + hasRust);
        System.out.println("Contains 'Kotlin': " + hasKotlin);
        System.out.println("Contains 'Swift': " + hasSwift);
        
        System.out.println("\n=== Testing contains with duplicates ===");
        
        MyArrayList<String> duplicatesList = new MyArrayList<>(5);
        duplicatesList.add("Apple");
        duplicatesList.add("Banana");
        duplicatesList.add("Apple");
        duplicatesList.add("Cherry");
        duplicatesList.add("Apple");
        System.out.println("List with duplicates: " + duplicatesList.toDetailedString());
        
        boolean hasApple = duplicatesList.contains("Apple");
        boolean hasBanana = duplicatesList.contains("Banana");
        boolean hasCherry = duplicatesList.contains("Cherry");
        boolean hasOrange = duplicatesList.contains("Orange");
        
        System.out.println("Contains 'Apple' (appears 3 times): " + hasApple);
        System.out.println("Contains 'Banana' (appears 1 time): " + hasBanana);
        System.out.println("Contains 'Cherry' (appears 1 time): " + hasCherry);
        System.out.println("Contains 'Orange' (appears 0 times): " + hasOrange);
        
        System.out.println("\n=== Testing contains with null values ===");
        
        MyArrayList<String> nullContainsList = new MyArrayList<>(4);
        nullContainsList.add("First");
        nullContainsList.add(null);
        nullContainsList.add("Third");
        nullContainsList.add(null);
        System.out.println("List with nulls: " + nullContainsList.toDetailedString());
        
        boolean hasFirst = nullContainsList.contains("First");
        boolean hasNull = nullContainsList.contains(null);
        boolean hasThird = nullContainsList.contains("Third");
        boolean hasNonExistent = nullContainsList.contains("NonExistent");
        
        System.out.println("Contains 'First': " + hasFirst);
        System.out.println("Contains null: " + hasNull);
        System.out.println("Contains 'Third': " + hasThird);
        System.out.println("Contains 'NonExistent': " + hasNonExistent);
        
        System.out.println("\n=== Testing contains with different types ===");
        
        MyArrayList<Integer> numberContainsList = new MyArrayList<>(4);
        numberContainsList.add(10);
        numberContainsList.add(20);
        numberContainsList.add(30);
        numberContainsList.add(20);
        System.out.println("Number list: " + numberContainsList.toDetailedString());
        
        boolean has10 = numberContainsList.contains(10);
        boolean has20 = numberContainsList.contains(20);
        boolean has30 = numberContainsList.contains(30);
        boolean has40 = numberContainsList.contains(40);
        
        System.out.println("Contains 10: " + has10);
        System.out.println("Contains 20 (appears twice): " + has20);
        System.out.println("Contains 30: " + has30);
        System.out.println("Contains 40: " + has40);
        
        System.out.println("\n=== Testing contains on empty list ===");
        
        MyArrayList<String> emptyContainsList = new MyArrayList<>();
        boolean hasAnythingInEmpty = emptyContainsList.contains("anything");
        boolean hasNullInEmpty = emptyContainsList.contains(null);
        
        System.out.println("Empty list contains 'anything': " + hasAnythingInEmpty);
        System.out.println("Empty list contains null: " + hasNullInEmpty);
        
        System.out.println("\n=== Demonstrating contains vs indexOf ===");
        
        MyArrayList<String> compareContainsList = new MyArrayList<>(4);
        compareContainsList.add("A");
        compareContainsList.add("B");
        compareContainsList.add("C");
        System.out.println("Demo list: " + compareContainsList.toDetailedString());
        
        // contains vs indexOf for existing element
        boolean containsB = compareContainsList.contains("B");
        int indexOfB = compareContainsList.indexOf("B");
        System.out.println("contains('B'): " + containsB + " (boolean result)");
        System.out.println("indexOf('B'): " + indexOfB + " (specific position)");
        
        // contains vs indexOf for non-existing element
        boolean containsX = compareContainsList.contains("X");
        int indexOfX = compareContainsList.indexOf("X");
        System.out.println("contains('X'): " + containsX + " (boolean result)");
        System.out.println("indexOf('X'): " + indexOfX + " (not found indicator)");
        
        System.out.println("\n=== Testing contains after modifications ===");
        
        MyArrayList<String> modifyList = new MyArrayList<>(3);
        modifyList.add("Before");
        modifyList.add("During");
        modifyList.add("After");
        System.out.println("Initial list: " + modifyList.toDetailedString());
        
        System.out.println("Initially contains 'During': " + modifyList.contains("During"));
        
        // Remove element and check again
        modifyList.remove("During");
        System.out.println("After removing 'During': " + modifyList.toDetailedString());
        System.out.println("Now contains 'During': " + modifyList.contains("During"));
        
        // Add element back and check
        modifyList.add("During");
        System.out.println("After adding 'During' back: " + modifyList.toDetailedString());
        System.out.println("Contains 'During' again: " + modifyList.contains("During"));
    }
}