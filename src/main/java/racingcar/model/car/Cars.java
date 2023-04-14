package racingcar.model.car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException("cars must not be null or empty");
        }
        this.cars = cars;
    }

    public List<Car> all() {
        return this.cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public int leaderDistance() {
        return cars.stream()
                .mapToInt(Car::distance)
                .max()
                .orElse(0);
    }

    public List<Car> leaders() {
        int leaderDistance = leaderDistance();

        return cars.stream()
                .filter(car -> car.isReached(leaderDistance))
                .collect(toList());
    }
}
