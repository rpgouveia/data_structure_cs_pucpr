import Linear.MyArrayList;

public class Test {
    public static void main(String[] args) {
        // Test: Construtor with specific capacity
        MyArrayList<String> list1 = new MyArrayList<>(5);
        System.out.println("List 1: " + list1);
        
        // Test: Construtor with default capacity
        MyArrayList<Integer> list2 = new MyArrayList<>();
        System.out.println("List 2: " + list2);

        // Test: Construtor with zero capacity (valid)
        MyArrayList<Double> list3 = new MyArrayList<>(0);
        System.out.println("List 3: " + list3);

        // Tests
        System.out.println("Is List 1 empty? " + list1.isEmpty());
        System.out.println("List 1 Capacity: " + list1.getCapacity());
        System.out.println("Current List Size 1: " + list1.size());
        System.out.println("List 2 Capacity: " + list2.getCapacity());
        System.out.println("Current List Size 2: " + list2.size());

        // Exception Test: (uncomment to test)
        // Exception in thread "main" java.lang.IllegalArgumentException: Capacity can not be negative: -1
        // MyArrayList<String> invalidList = new MyArrayList<>(-1);
    }
}