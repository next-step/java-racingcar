package step05.domain;

import step03.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public static Cars of(String[] carNames) {
        return Cars.of(
                Arrays.stream(carNames)
                        .map((carName) -> Car.of(carName))
                        .collect(Collectors.toList())
        );
    }

    public static Cars of(String[] carNames, int position) {
        return Cars.of(
                Arrays.stream(carNames)
                        .map((carName) -> Car.of(carName, position))
                        .collect(Collectors.toList())
        );
    }

    public static Cars of(String[] carNames, int position, int maxLength) {
        return Cars.of(
                Arrays.stream(carNames)
                        .map((carName) -> Car.of(carName, position, maxLength))
                        .collect(Collectors.toList())
        );
    }

    public Cars move(MoveStrategy moveStrategy) {
        return Cars.of(
                cars.stream()
                        .map(car -> car.move(moveStrategy))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return cars.equals(cars1.cars);
    }

}
