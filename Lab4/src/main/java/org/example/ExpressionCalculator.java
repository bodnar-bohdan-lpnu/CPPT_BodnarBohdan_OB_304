package org.example;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для обчислення виразу y = tan(x).
 * Використовується для демонстрації механізму виключень і запису результатів у файл.
 */
public class ExpressionCalculator {
    /**
     * Обчислює вираз y = tan(x).
     *
     * @param x значення змінної x
     * @return результат обчислення виразу
     * @throws IllegalArgumentException якщо x = 0, оскільки вираз не визначений
     */
    public double calculate(double x) throws IllegalArgumentException {
        if (x == 0) {
            throw new IllegalArgumentException("Значення x не може бути 0, оскільки вираз не визначений.");
        }
        return Math.cos(x) / Math.sin(x);
    }

    /**
     * Записує результат обчислення у файл.
     *
     * @param result результат обчислення
     * @param filePath шлях до файлу
     * @throws IOException якщо виникає помилка при записі у файл
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (var writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }
}