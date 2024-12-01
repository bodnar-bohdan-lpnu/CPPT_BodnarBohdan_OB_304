package КI_304.Bodnar.Lab6;
/**
 * Клас для демонстрації роботи з контейнером об'єктів
 */
public class LinkedListDriver {
    /**
     * Головний метод для запуску програми
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        // Створюємо список
        LinkedList<Valuable> list = new LinkedList<>();

        // Тестуємо додавання елементів
        System.out.println("1. Тестування додавання елементів:");
        list.add(new Student("John", 85, "KN-221"));
        list.add(new Book("Java Programming", "James Gosling", 800, 2020));
        list.addFirst(new Student("Alice", 92, "KN-221"));
        list.add(new Book("Clean Code", "Robert Martin", 464, 2008));

        System.out.println("Розмір після додавання: " + list.size());
        printAll(list);

        // Тестуємо пошук мінімального елемента
        System.out.println("\n2. Тестування пошуку мінімального елемента:");
        System.out.println("Мінімальний елемент: " + list.findMin());

        // Тестуємо видалення
        System.out.println("\n3. Тестування видалення:");
        System.out.println("Видалений перший елемент: " + list.removeFirst());
        System.out.println("Видалений елемент за індексом 1: " + list.remove(1));
        System.out.println("\nСписок після видалення:");
        printAll(list);

        // Тестуємо отримання елементів
        System.out.println("\n4. Тестування отримання елементів:");
        System.out.println("Перший елемент: " + list.get(0));
        System.out.println("Розмір списку: " + list.size());
    }

    /**
     * Допоміжний метод для виведення всіх елементів
     */
    private static void printAll(LinkedList<Valuable> list) {
        System.out.println("Всі елементи:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}