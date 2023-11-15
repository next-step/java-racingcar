package racingcar.domain;

import java.util.Comparator;
import java.util.stream.Collectors;
import racingcar.utils.NumberGenerator;

import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Round moveForwardCars(final NumberGenerator numberGenerator) {
        cars.stream().forEach(car -> car.tryMove(numberGenerator.generateNumber()));
        return new Round(copyCars());
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Position getMaxPosition() {
        return cars.stream()
            .map(Car::getCarPosition)
            .max(Position::compareTo)
            .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다."));
    }

    public List<Car> findWinners() {
        return cars.stream()
            .filter(car -> car.isAtPosition(getMaxPosition()))
            .collect(Collectors.toList());
    }

    public Cars copyCars() {
        return new Cars(cars.stream()
            .map(Car::copyCar)
            .collect(Collectors.toList()));
    }

}
