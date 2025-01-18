public class Main {
    public static void main(String[] args) throws FullException {
        try {
            // Test 1: Tworzenie pustej kolejki
            Queue<Integer> queue = new Queue<>(3);
            System.out.println("Is queue empty? " + queue.isEmpty()); // true

            // Test 2: Dodanie elementów
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            System.out.println("Is queue full? " + queue.isFull()); // true

            // Test 3: Próba przepełnienia
            try {
                queue.enqueue(40);
            } catch (FullException e) {
                System.out.println(e.getMessage()); // "Queue is full"
            }

            // Test 4: Pobieranie elementu z początku kolejki
            System.out.println("First element: " + queue.first()); // 10

            // Test 5: Usunięcie elementów
            queue.dequeue();
            System.out.println("First element after dequeue: " + queue.first()); // 20
            queue.dequeue();
            queue.dequeue();

            // Test 6: Próba usunięcia z pustej kolejki
            try {
                queue.dequeue();
            } catch (EmptyException e) {
                System.out.println(e.getMessage()); // "Queue is empty"
            }

            // Test 7: Dodanie elementów po usunięciu
            queue.enqueue(40);
            System.out.println("First element: " + queue.first()); // 40

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}