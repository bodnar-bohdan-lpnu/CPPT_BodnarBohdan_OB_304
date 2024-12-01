package КI_304.Bodnar.Lab6;

/**
 * Параметризований клас для однозв'язного списку
 * @param <T> тип елементів списку
 */
public class LinkedList<T> {
    /**
     * Внутрішній клас для представлення вузла списку
     */
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    /**
     * Конструктор за замовчуванням
     */
    public LinkedList() {
        head = null;
        size = 0;
    }

    /**
     * Додає елемент в кінець списку
     * @param element елемент для додавання
     */
    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Додає елемент на початок списку
     * @param element елемент для додавання
     */
    public void addFirst(T element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Видаляє перший елемент списку
     * @return видалений елемент
     * @throws IllegalStateException якщо список порожній
     */
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }

    /**
     * Видаляє елемент за вказаним індексом
     * @param index індекс елемента для видалення
     * @return видалений елемент
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі списку
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return removeFirst();
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T data = current.next.data;
        current.next = current.next.next;
        size--;
        return data;
    }

    /**
     * Знаходить мінімальний елемент в списку
     * @return мінімальний елемент
     * @throws IllegalStateException якщо список порожній
     */
    public T findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node current = head;
        T min = current.data;
        while (current != null) {
            if (((Valuable)current.data).getValue() < ((Valuable)min).getValue()) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    /**
     * Повертає елемент за вказаним індексом
     * @param index індекс елемента
     * @return елемент списку
     * @throws IndexOutOfBoundsException якщо індекс виходить за межі списку
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Повертає розмір списку
     * @return кількість елементів у списку
     */
    public int size() {
        return size;
    }

    /**
     * Перевіряє чи порожній список
     * @return true якщо список порожній, інакше false
     */
    public boolean isEmpty() {
        return size == 0;
    }
}