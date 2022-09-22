package racingcar;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import static java.util.stream.Collectors.toList;

public class Cars {
    private static final Integer MIN_NUM = 0;
    private static final Integer MAX_NUM = 10;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        List<Car> cars = names.stream()
                .map(name -> Car.of(0, name))
                .collect(toList());
        return new Cars(cars);
    }

    public List<Car> cars() {
        return cars;
    }

    public Cars next() {
        List<Car> nextCars = cars.stream()
                .map(car -> {
                    int randomNumber = ThreadLocalRandom.current().nextInt(MIN_NUM, MAX_NUM);
                    return Car.of(car.nextPosition(randomNumber), car.name());
                }).collect(toList());
        return new Cars(nextCars);
    }

    public List<Car> winners() {
        return findCarsByPosition(maxPosition());
    }

    private Integer maxPosition() {
        return cars.stream()
                .max(Comparator.comparing(Car::currentPosition))
                .orElseThrow(IllegalStateException::new)
                .currentPosition();
    }

    private List<Car> findCarsByPosition(Integer position) {
        return cars.stream()
                .filter(car -> Objects.equals(car.currentPosition(), position))
                .collect(toList());
    }
}
