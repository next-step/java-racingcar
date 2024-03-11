package step3.service;

import step3.view.CarMovementResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarsDto {
    private final List<Car> cars = new ArrayList<>();

    public static CarsDto randomStrategyCars(int carCount) {
        return new CarsDto(
                IntStream.range(0, carCount)
                        .mapToObj(idx -> Car.randomMovingCar())
                        .collect(Collectors.toList())
        );
    }

    private CarsDto(List<Car> cars) {
        if (cars != null && cars.size() > 0) {
            this.cars.addAll(cars);
        }
    }

    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public void moveAll() {
        cars.forEach(Car::move);
    }

    public List<CarMovementResult> movementResults() {
        return cars.stream()
                .map(Car::movementResult)
                .collect(Collectors.toList());
    }
}
