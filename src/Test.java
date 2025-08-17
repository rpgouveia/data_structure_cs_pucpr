import Linear.MyArrayList;

public class Test {
    public static void main(String[] args) {
        // Teste do construtor com capacidade específica
        MyArrayList<String> lista1 = new MyArrayList<>(5);
        System.out.println("Lista1: " + lista1);
        
        // Teste do construtor padrão
        MyArrayList<Integer> lista2 = new MyArrayList<>();
        System.out.println("Lista2: " + lista2);
        
        // Teste com capacidade 0 (válido)
        MyArrayList<Double> lista3 = new MyArrayList<>(0);
        System.out.println("Lista3: " + lista3);
        
        // Teste de verificação de estado
        System.out.println("Lista1 está vazia? " + lista1.isEmpty());
        System.out.println("Capacidade da lista1: " + lista1.getCapacity());
        System.out.println("Tamanho atual da lista1: " + lista1.size());
        System.out.println("Capacidade da lista2: " + lista2.getCapacity());
        System.out.println("Tamanho atual da lista2: " + lista2.size());
        
        // Este teste causará exceção (descomente para testar)
        // Exception in thread "main" java.lang.IllegalArgumentException: Capacity can not be negative: -1
        // MyArrayList<String> listaInvalida = new MyArrayList<>(-1);
    }
}