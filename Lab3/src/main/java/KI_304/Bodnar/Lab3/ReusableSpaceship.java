package KI_304.Bodnar.Lab3;

import java.io.IOException;

/**
 * Клас ReusableSpaceship розширює Spaceship та реалізує інтерфейс Reusable.
 */
public class ReusableSpaceship extends Spaceship  implements Reusable {
    private boolean readyForReuse;

    /**
     * Конструктор для створення багаторазового космічного корабля.
     */
    public ReusableSpaceship(Engine engine, NavigationSystem navigationSystem, LifeSupportSystem lifeSupportSystem,
                             String name, double shieldEnergy, boolean shieldActive) throws IOException {
        super(engine, navigationSystem, lifeSupportSystem, name, shieldEnergy, shieldActive);
        this.readyForReuse = true;
    }

    @Override
    public void prepareForReuse() throws IOException {
        engine.setFuel(500); // Заправка до повного бака
        shieldEnergy = 1000; // Відновлення енергії щита
        readyForReuse = true;
        logger.log("Корабель підготовлено до повторного використання");
    }

    @Override
    public boolean isReadyForReuse() throws IOException {
        logger.log("Перевірка готовності до повторного використання: " + readyForReuse);
        return readyForReuse;
    }

    @Override
    public void performSpecificOperation() throws IOException {
        logger.log("Виконання специфічної операції для багаторазового корабля");
        System.out.println("Виконання специфічної операції для багаторазового корабля");
    }

    /**
     * Метод для симуляції посадки корабля.
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void land() throws IOException {
        readyForReuse = false;
        logger.log("Корабель здійснив посадку. Потрібна підготовка до повторного використання.");
        System.out.println("Корабель здійснив посадку. Потрібна підготовка до повторного використання.");
    }
}