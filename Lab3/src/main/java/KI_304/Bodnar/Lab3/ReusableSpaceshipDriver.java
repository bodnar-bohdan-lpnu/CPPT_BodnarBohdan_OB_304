package KI_304.Bodnar.Lab3;

import java.io.IOException;

/**
 * Клас SpaceshipDriver є точкою входу для запуску програми, яка демонструє використання космічного корабля (Spaceship).
 * Він створює екземпляр космічного корабля, викликає основні методи і демонструє роботу з системами корабля.
 */
public class ReusableSpaceshipDriver {
    /**
     * Головний метод, який запускає програму і демонструє роботу з космічним кораблем.
     *
     * @param args Аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            ReusableSpaceship reusableShip = new ReusableSpaceship(
                    new Engine(false, 400),
                    new NavigationSystem(0, 0, 0),
                    new LifeSupportSystem(),
                    "Reusable-1",
                    1000,
                    false
            );

            System.out.println("Демонстрація роботи багаторазового космічного корабля:");

            reusableShip.startEngine();
            reusableShip.navigateTo(100, 200, 300);
            reusableShip.checkFuelLevel();
            reusableShip.activateShield();
            reusableShip.performSpecificOperation();
            reusableShip.land();

            System.out.println("Готовність до повторного використання: " + reusableShip.isReadyForReuse());

            reusableShip.prepareForReuse();
            System.out.println("Після підготовки. Готовність до повторного використання: " + reusableShip.isReadyForReuse());

            reusableShip.getInfo();
            reusableShip.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл.
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}