package KI_304.Bodnar.Lab3;

import java.io.IOException;

/**
 * Клас Spaceship представляє космічний корабель, який оснащений двигуном, навігаційною системою,
 * системою життєзабезпечення та захисним полем. Клас також веде логування подій.
 */
public abstract class Spaceship {
    protected  Engine engine;
    protected  NavigationSystem navigationSystem;
    protected  LifeSupportSystem lifeSupportSystem;
    protected  String name;
    protected  double shieldEnergy;
    protected  boolean shieldActive;
    protected  Logger logger;

    /**
     * Конструктор за замовчуванням, що створює космічний корабель з початковими параметрами.
     * @throws IOException якщо виникає помилка під час створення лог-файлу
     */
    public Spaceship() throws IOException {
        this(new Engine(false, 500),
                new NavigationSystem(0, 0, 0),
                new LifeSupportSystem(), "Мрія", 1000, false);
        this.logger = new Logger("spaceship_log.txt");

        logger.log(String.format("Космічний корабель %s сторено.", this.toString()));
    }

    /**
     * Конструктор, що дозволяє створити космічний корабель з заданими параметрами.
     *
     * @param engine Двигун корабля
     * @param navigationSystem Навігаційна система корабля
     * @param lifeSupportSystem Система життєзабезпечення
     * @param name Ім'я корабля
     * @param shieldEnergy Початкова енергія щита
     * @param shieldActive Чи активний щит при створенні корабля
     * @throws IOException якщо виникає помилка під час створення лог-файлу
     */
    public Spaceship(Engine engine,
                     NavigationSystem navigationSystem,
                     LifeSupportSystem lifeSupportSystem,
                     String name,
                     double shieldEnergy,
                     boolean shieldActive) throws IOException {
        this.engine = engine;
        this.navigationSystem = navigationSystem;
        this.lifeSupportSystem = lifeSupportSystem;
        this.name = name;
        this.shieldEnergy = shieldEnergy;
        this.shieldActive = shieldActive;

        this.logger = new Logger("spaceship_log.txt");

        logger.log(String.format("Космічний корабель %s сторено.", this.toString()));
    }

    /**
     * Абстрактний метод для виконання специфічних операцій корабля.
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public abstract void performSpecificOperation() throws IOException;

    /**
     * Метод для запуску двигуна.
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void startEngine() throws IOException {
        engine.start();

        logger.log("Двигун запущено");
        System.out.println("Двигун запущено");
    }

    /**
     * Метод для зупинки двигуна.
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void stopEngine() throws IOException {
        engine.stop();

        logger.log("Двигун зупинено");
        System.out.println("Двигун зупинено");
    }

    /**
     * Метод для навігації до заданих координат.
     *
     * @param x Координата X
     * @param y Координата Y
     * @param z Координата Z
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void navigateTo(double x, double y, double z) throws IOException {
        navigationSystem.setCoordinates(x, y, z);

        logger.log(String.format("Встановлено курс на координати: %s,%s,%s ", x, y, z));
        System.out.printf("Встановлено курс на координати: %s,%s,%s \n", x, y, z);
    }

    /**
     * Метод для перевірки рівня кисню.
     *
     * @return Рівень кисню у відсотках
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public double checkOxygenLevel() throws IOException {
        double oxygenLevel = lifeSupportSystem.getOxygenLevel();

        logger.log(String.format("Перевірено рівень кисню: %s", oxygenLevel));
        System.out.printf("Перевірено рівень кисню: %s\n", oxygenLevel);
        return oxygenLevel;
    }

    /**
     * Метод для дозаправки корабля.
     *
     * @param amount Кількість палива для дозаправки
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void refuel(double amount) throws IOException {
        double fuelLevel = engine.getFuel() + amount;

        if (fuelLevel < 500.0) {
            engine.setFuel(fuelLevel);
        }else {
            logger.log(String.format("Кількість палива %s для дозаправки більша ніж ємність бака", amount));
            System.out.printf("Кількість палива %s для дозаправки більша ніж ємність бака\n", amount);
        }

        logger.log(String.format("Дозаправлено корабель. Новий рівень палива: %s", fuelLevel));
        System.out.printf("Дозаправлено корабель. Новий рівень палива: %s\n", fuelLevel);
    }

    /**
     * Метод для перевірки рівня палива.
     *
     * @return Рівень палива у відсотках
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public double checkFuelLevel() throws IOException {
        logger.log(String.format("Перевірено рівень палива: %s", engine.getFuel()));
        System.out.printf("Перевірено рівень палива: %s\n", engine.getFuel());

        return engine.getFuel();
    }

    /**
     * Метод для отримання інформації про корабель.
     *
     * @return Рядок з інформацією про корабель
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public String getInfo() throws IOException {
        String info = String.format("Корабель: %s, Паливо: %s, Кисень: %s", name, engine.getFuel(), checkOxygenLevel());

        logger.log(String.format("Дістати інфо про %s", info));
        System.out.printf("Дістати інфо про %s\n", info);
        return info;
    }

    /**
     * Метод для активації захисного поля.
     *
     * @return true, якщо поле успішно активовано, false - якщо недостатньо енергії
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public boolean activateShield() throws IOException {
        if (shieldEnergy >= 20.0 && !shieldActive) {
            shieldActive = true;
            shieldEnergy -= 20.0;

            logger.log(String.format("Активовано захисне поле. Залишок енергії щита: %s", shieldEnergy));
            System.out.printf("Активовано захисне поле. Залишок енергії щита: %s", shieldEnergy);
            return true;
        } else {
            logger.log("Не вдалося активувати захисне поле. Недостатньо енергії або щит вже активний.");
            System.out.println("Не вдалося активувати захисне поле. Недостатньо енергії або щит вже активний.");
            return false;
        }
    }

    /**
     * Метод для деактивації захисного поля.
     *
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public void deactivateShield() throws IOException {
        if (shieldActive) {
            shieldActive = false;

            logger.log(String.format("Деактивовано захисне поле. Поточна енергія щита: %s", shieldEnergy));
            System.out.printf("Деактивовано захисне поле. Поточна енергія щита: %s\n", shieldEnergy);
        } else {
            logger.log("Захисне поле вже деактивовано.");
            System.out.println("Захисне поле вже деактивовано.");
        }
    }

    /**
     * Метод для перевірки стану щита.
     *
     * @return Рядок зі станом щита
     * @throws IOException якщо виникає помилка при записі в лог
     */
    public String checkShieldStatus() throws IOException {
        String status = "Щит " + (shieldActive ? "активний" : "неактивний") +
                ". Енергія щита: " + shieldEnergy + "%";

        logger.log(String.format("Перевірено стан щита: %s", status));
        System.out.printf("Перевірено стан щита: %s", status);
        return status;
    }

    /**
     * Метод для коректного закриття логера.
     *
     * @throws IOException якщо виникає помилка під час закриття лог-файлу.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }

    @Override
    public String toString() {
        return "Spaceship{" +
                "engine=" + engine +
                ", navigationSystem=" + navigationSystem +
                ", lifeSupportSystem=" + lifeSupportSystem +
                ", name='" + name + '\'' +
                ", shieldEnergy=" + shieldEnergy +
                ", shieldActive=" + shieldActive +
                ", logger=" + logger +
                '}';
    }
}

