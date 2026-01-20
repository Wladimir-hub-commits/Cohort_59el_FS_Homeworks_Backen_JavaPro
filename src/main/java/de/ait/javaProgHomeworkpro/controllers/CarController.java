package de.ait.javaProgHomeworkpro.controllers;



import de.ait.javaProgHomeworkpro.model.Car;
import de.ait.javaProgHomeworkpro.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final List<Car> allCars =  new ArrayList<>(List.of(
            new Car(1L,"BMW", "X5", 2020, 3000, 35000, "AVAILABLE"),
            new Car(2L,"AUDI", "A6", 2025, 15000, 55000, "SOLD"),
            new Car(3L, "BMW", "M3", 2021, 8000, 72000, "Sold"),
            new Car(4L,"AUDI", "Q7", 2024, 35000, 45000, "AVAILABLE")
    ));

    @GetMapping
    public List<Car> getAllCars()
    {
        return allCars;

    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id){
        for (Car car : allCars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null; // или можно выбросить исключение или вернуть ResponseEntity с 404

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable Long id) {
        Iterator<Car> iterator = allCars.iterator();
        while (iterator.hasNext()) {
            Car car = iterator.next();
            if (car.getId().equals(id)) {
                iterator.remove();
                return ResponseEntity.noContent().build(); // 204 No Content
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Car with ID " + id + " not found");
    }
    // Новый метод для фильтрации по марке
    @GetMapping("/brand/{brand}")
    public List<Car> getCarsByBrand(@PathVariable String brand) {

        return CarService.getCarsByBrand(brand);
    }

//Объяснение:
//allCars теперь — это ArrayList, чтобы можно было удалять элементы.
//В методе deleteCar используется итератор для безопасного удаления элемента во время обхода списка.
//Поиск по id осуществляется через цикл, сравнивая car.getId() с переданным id.
//Возвращается сообщение о результате удаления или о том, что автомобиль не найден.
//

}
