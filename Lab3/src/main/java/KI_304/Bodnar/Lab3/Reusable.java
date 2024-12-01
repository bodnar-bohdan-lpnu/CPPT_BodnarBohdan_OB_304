package KI_304.Bodnar.Lab3;

import java.io.IOException;

/**
 * Інтерфейс для багаторазових космічних кораблів.
 */
interface Reusable {
    /**
     * Метод для підготовки корабля до повторного використання.
     * @throws IOException якщо виникає помилка при записі в лог
     */
    void prepareForReuse() throws IOException;

    /**
     * Метод для перевірки готовності корабля до повторного використання.
     * @return true, якщо корабель готовий до повторного використання, false - якщо ні
     * @throws IOException якщо виникає помилка при записі в лог
     */
    boolean isReadyForReuse() throws IOException;
}