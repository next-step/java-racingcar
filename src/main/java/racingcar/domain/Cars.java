package racingcar.domain;

import racingcar.utils.NumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public void moveForwardCars(final NumberGenerator numberGenerator) {
        cars.stream().forEach(car -> car.tryMove(numberGenerator.generateNumber()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Cars copyCars() {
        return new Cars(cars.stream()
                .map(Car::copyCar)
                .collect(Collectors.toList()));
    }

}
