package КI_304.Bodnar.Lab6;

/**
 * Клас, що представляє студента
 */
class Student implements Valuable {
    private String name;
    private int grade;
    private String group;

    /**
     * Конструктор класу Student
     * @param name ім'я студента
     * @param grade оцінка студента
     * @param group група студента
     */
    public Student(String name, int grade, String group) {
        this.name = name;
        this.grade = grade;
        this.group = group;
    }

    /**
     * Повертає оцінку студента
     * @return оцінка студента
     */
    @Override
    public int getValue() {
        return grade;
    }

    /**
     * Повертає рядкове представлення студента
     * @return інформація про студента у вигляді рядка
     */
    @Override
    public String toString() {
        return "Student{name='" + name + "', grade=" + grade + ", group='" + group + "'}";
    }
}