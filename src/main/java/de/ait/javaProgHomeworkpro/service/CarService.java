package de.ait.javaProgHomeworkpro.service;

import de.ait.javaProgHomeworkpro.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class CarService {
    // Можно передавать список или получать его из базы, тут для примера используем список из контроллера
    private static List<Car> allCars = List.of();

    public void CarService() {
        this.allCars = List.of(
                new Car(1L, "BMW", "X5", 2020, 3000, 35000, "AVAILABLE"),
                new Car(2L, "AUDI", "A6", 2025, 15000, 55000, "SOLD"),
                new Car(3L, "BMW", "M3", 2021, 8000, 72000, "AVAILABLE"),
                new Car(4L,"AUDI", "Q7", 2024, 35000, 45000, "AVAILABLE")
        );
    }

    public static List<Car> getCarsByBrand(String brand) {
        return allCars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }
}
