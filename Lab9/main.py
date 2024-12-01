from ReusableSpacecraft import ReusableSpacecraft

if __name__ == "__main__":
    # Створюємо багаторазовий космічний корабель
    starship = ReusableSpacecraft("Starship", 2000, 1500, 5)

    # Виводимо початковий стан
    print("\n1. Початковий стан:")
    print(starship.get_status())

    # Спробуємо запустити - має вийти
    print("\n2. Перший запуск:")
    starship.launch()
    print(starship.get_status())

    # Приземляємо корабель
    print("\n3. Приземлення:")
    starship.land()
    print(starship.get_status())

    # Робимо ще два запуски, щоб викликати необхідність обслуговування
    print("\n4. Ще два запуски підряд:")
    starship.launch()
    starship.land()
    starship.launch()
    starship.land()
    print(starship.get_status())

    # Спробуємо запустити без обслуговування
    print("\n5. Спроба запуску без обслуговування:")
    starship.launch()

    # Виконуємо обслуговування
    print("\n6. Виконання технічного обслуговування:")
    starship.perform_maintenance()
    print(starship.get_status())

    # Дозаправляємо корабель
    print("\n7. Дозаправка:")
    starship.refuel()
    print(starship.get_status())

    # Робимо ще два польоти
    print("\n8. Ще два польоти:")
    starship.launch()
    starship.land()
    starship.launch()  # П'ятий запуск - останній можливий
    starship.land()
    print(starship.get_status())

    # Спробуємо зробити запуск після досягнення максимуму польотів
    print("\n9. Спроба запуску після досягнення ліміту польотів:")
    starship.launch()

    # Перевіряємо фінальний стан
    print("\n10. Фінальний стан корабля:")
    print(starship.get_status())

    # Демонструємо всі атрибути об'єкта
    print("\n11. Всі атрибути корабля:")
    print(f"Назва: {starship.name}")
    print(f"Маса: {starship.mass} кг")
    print(f"Ємність палива: {starship.fuel_capacity} л")
    print(f"Поточний рівень палива: {starship.current_fuel} л")
    print(f"Максимум польотів: {starship.max_flights}")
    print(f"Виконано польотів: {starship.flights_completed}")
    print(f"Потребує обслуговування: {starship.needs_maintenance}")
    print(f"В космосі: {starship.is_in_space}")