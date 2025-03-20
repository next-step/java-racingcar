package car_racing2.model;

import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private final BooleanSupplier movingStrategy;

    public Cars(List<String> carsNames, BooleanSupplier movingStrategy) {
        this.cars = createCars(carsNames);
        this.movingStrategy = movingStrategy;
    }

    public void moveAll() {
        for (Car car : cars) {
            if (movingStrategy.getAsBoolean()) car.move();
        }
    }

    public List<String> getPositionsOfCars() {
        return cars.stream()
                .map(Car::getPositionWithName)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(Integer.MIN_VALUE);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
