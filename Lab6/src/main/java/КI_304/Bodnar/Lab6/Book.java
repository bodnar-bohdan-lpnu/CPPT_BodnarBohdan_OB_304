package КI_304.Bodnar.Lab6;

/**
 * Клас, що представляє книгу
 */
class Book implements Valuable {
    private String title;
    private String author;
    private int pages;
    private int year;

    /**
     * Конструктор класу Book
     * @param title назва книги
     * @param author автор книги
     * @param pages кількість сторінок
     * @param year рік видання
     */
    public Book(String title, String author, int pages, int year) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }

    /**
     * Повертає кількість сторінок книги
     * @return кількість сторінок
     */
    @Override
    public int getValue() {
        return pages;
    }

    /**
     * Повертає рядкове представлення книги
     * @return інформація про книгу у вигляді рядка
     */
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author +
                "', pages=" + pages + ", year=" + year + "}";
    }
}