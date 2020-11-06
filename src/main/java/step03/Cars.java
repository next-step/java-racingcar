package step03;

import step03.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {
    public List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of (int numberOfCars, int position, MoveStrategy moveStrategy) {
        validateNumberOfCars(numberOfCars);
        return new Cars(Stream.iterate(0, n -> n + 1)
                        .limit(numberOfCars)
                        .map(n -> Car.of(position, moveStrategy))
                        .collect(Collectors.toList()));
    }

    private static void validateNumberOfCars(int numberOfCars) {
        Validator.validatePositiveNumber(numberOfCars);
    }

    public void move() {
        cars.forEach(car -> car.move());
    }

    public List<Car> getCars () {
        return cars;
    }
}
