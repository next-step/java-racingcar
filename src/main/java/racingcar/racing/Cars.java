package racingcar.racing;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void add(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        cars.add(car);
    }

    public void moveAll() {
        cars.forEach(Car::play);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getCarsWithMaxDistance() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        cars.forEach(car -> {
            result.append(car.getName()).append(" : ");
            result.append("-".repeat(Math.max(0, car.getDistance())));
            result.append("\n");
        });

        return result.toString();
    }
}
