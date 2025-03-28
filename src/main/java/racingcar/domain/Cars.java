package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll() {
        cars.forEach(Car::play);
    }

    public List<Car> getCarsWithMaxDistance() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
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
