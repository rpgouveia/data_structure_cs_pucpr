package linear;

public class MyStackTest {
    public static void main(String[] args) {
        System.out.println("=== MyStack Test ===");
        // Basic constructor test
        MyStack<String> list1 = new MyStack<>();

        // Test empty list
        System.out.println("list1: " + list1);

        // Test pushing elements
        list1.push("Angelo");
        list1.push("Fernando");
        list1.push("Jafte");
        list1.push("Renato");
        list1.push("Spencer");
        System.out.println("list1: " + list1);

        // Test printing elements
        list1.printElements();

        // Test peeking at elements
        System.out.println("Peek: " + list1.peek());

        // Test removing elements
        System.out.println("\nRemoving and printing elements:");
        while (!list1.isEmpty()) {
            System.out.println("Popped: " + list1.pop());
        }
    }
}
