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

    public static Cars of(Car... cars) {
        return new Cars(List.of(cars));
    }

    public List<Car> all() {
        return this.cars;
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public Distance leaderDistance() {
        return cars.stream()
                .map(Car::distance)
                .max(Distance::compareTo)
                .orElse(Distance.ZERO);
    }

    public List<Car> leaders() {
        Distance leaderDistance = leaderDistance();

        return cars.stream()
                .filter(car -> car.isReached(leaderDistance))
                .collect(toList());
    }
}
