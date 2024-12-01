class Spacecraft:
    """
    Клас Spacecraft представляє космічний корабель із базовими характеристиками та функціями.
    """

    def __init__(self, name, mass, fuel_capacity):
        """
        Ініціалізує об'єкт космічного корабля.

        :param name: Ім'я корабля.
        :param mass: Маса корабля в кілограмах.
        :param fuel_capacity: Максимальна ємність палива в літрах.
        """
        self.name = name
        self.mass = mass  # маса в кг
        self.fuel_capacity = fuel_capacity  # ємність палива в літрах
        self.current_fuel = fuel_capacity  # початковий рівень палива
        self.is_in_space = False  # початковий стан - на землі

    def launch(self):
        """
        Виконує запуск космічного корабля, якщо є достатньо палива.

        :return: True, якщо запуск успішний, False - якщо недостатньо палива.
        """
        if self.current_fuel > self.fuel_capacity * 0.2:  # потрібно мінімум 20% палива для запуску
            print(f"Корабель {self.name} стартує!")
            self.is_in_space = True  # змінюємо статус корабля
            self.current_fuel -= self.fuel_capacity * 0.2  # витрачається 20% палива на запуск
            return True
        else:
            print(f"Недостатньо палива для запуску корабля {self.name}")
            return False

    def land(self):
        """
        Виконує посадку космічного корабля, якщо він перебуває у космосі.

        :return: True, якщо посадка успішна, False - якщо корабель вже на землі.
        """
        if self.is_in_space:
            print(f"Корабель {self.name} приземляється")
            self.is_in_space = False  # змінюємо статус корабля
            return True
        return False

    def refuel(self):
        """
        Заправляє корабель до максимальної ємності палива.
        """
        self.current_fuel = self.fuel_capacity
        print(f"Корабель {self.name} заправлений")

    def get_status(self):
        """
        Отримує поточний статус космічного корабля.

        :return: Строка із статусом корабля (у космосі/на землі) та рівнем палива.
        """
        status = "у космосі" if self.is_in_space else "на землі"
        return f"Корабель {self.name}: {status}, паливо: {self.current_fuel}/{self.fuel_capacity} л"

