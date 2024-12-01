package org.KI_304.Bodnar.Lab2;


import java.io.IOException;

/**
 * Клас SpaceshipDriver є точкою входу для запуску програми, яка демонструє використання космічного корабля (Spaceship).
 * Він створює екземпляр космічного корабля, викликає основні методи і демонструє роботу з системами корабля.
 */
public class SpaceshipDriver {
    /**
     * Головний метод, який запускає програму і демонструє роботу з космічним кораблем.
     *
     * @param args Аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            Spaceship spaceship = new Spaceship(
                    new Engine(false, 400),
                    new NavigationSystem(0, 0, 0),
                    new LifeSupportSystem(),
                    "NASA",
                    1000,
                    true
            );

            spaceship.startEngine();
            spaceship.stopEngine();
            spaceship.navigateTo(100, 200, 100);
            spaceship.checkOxygenLevel();
            spaceship.checkFuelLevel();
            spaceship.refuel(100);
            spaceship.getInfo();
            spaceship.checkShieldStatus();
            spaceship.activateShield();
            spaceship.deactivateShield();
            spaceship.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}

