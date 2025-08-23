package linear;

public class MyStackTest {
    public static void main(String[] args) {
        System.out.println("=== MyStack Test ===");
        MyStack<String> list1 = new MyStack<>();

        System.out.println("list1: " + list1);

        list1.push("Angelo");
        list1.push("Fernando");
        list1.push("Jafte");
        list1.push("Renato");
        list1.push("Spencer");
        System.out.println("list1: " + list1);
    }
}
