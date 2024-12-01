from Spacecraft import Spacecraft


class ReusableSpacecraft(Spacecraft):
    """
    Клас ReusableSpacecraft розширює функціональність базового класу Spacecraft,
    додаючи можливість повторного використання корабля з обмеженою кількістю польотів
    та необхідністю регулярного технічного обслуговування.
    """

    def __init__(self, name, mass, fuel_capacity, max_flights):
        """
        Ініціалізує об'єкт багаторазового космічного корабля.

        :param name: Ім'я корабля.
        :param mass: Маса корабля в кілограмах.
        :param fuel_capacity: Максимальна ємність палива в літрах.
        :param max_flights: Максимальна кількість польотів, які корабель може виконати.
        """
        super().__init__(name, mass, fuel_capacity)
        self.max_flights = max_flights  # максимальна кількість польотів
        self.flights_completed = 0  # кількість виконаних польотів
        self.needs_maintenance = False  # статус технічного обслуговування

    def launch(self):
        """
        Виконує запуск корабля, враховуючи його технічний стан та кількість польотів.

        :return: True, якщо запуск успішний, False - якщо запуск неможливий через
                 технічні причини або досягнення ліміту польотів.
        """
        if self.needs_maintenance:
            print(f"Корабель {self.name} потребує технічного обслуговування перед запуском")
            return False
        if self.flights_completed >= self.max_flights:
            print(f"Корабель {self.name} досяг максимальної кількості польотів")
            return False

        launch_successful = super().launch()  # спроба запуску через базовий клас
        if launch_successful:
            self.flights_completed += 1
            # Кожні 3 польоти потрібне технічне обслуговування
            if self.flights_completed % 3 == 0:
                self.needs_maintenance = True
        return launch_successful

    def perform_maintenance(self):
        """
        Виконує технічне обслуговування корабля, знімаючи статус потреби у ремонті.
        """
        self.needs_maintenance = False
        print(f"Виконано технічне обслуговування корабля {self.name}")

    def get_status(self):
        """
        Отримує поточний статус багаторазового корабля, включаючи його польоти та технічний стан.

        :return: Строка із статусом корабля, кількістю польотів та технічним станом.
        """
        basic_status = super().get_status()  # отримує статус із базового класу
        maintenance_status = "потребує обслуговування" if self.needs_maintenance else "справний"
        return f"{basic_status}, польотів: {self.flights_completed}/{self.max_flights}, стан: {maintenance_status}"
