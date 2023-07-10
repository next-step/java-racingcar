package car.model;

import car.model.util.NumberGenerator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    public Cars(final CarNames carNames) {
        cars = carNames.getCarNames().stream()
            .map(car -> new Car(car.getName()))
            .collect(Collectors.toList());
    }

    public Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public Cars race(final NumberGenerator numberGenerator) {
        List<Car> collect = this.cars.stream().map(car -> car.move(numberGenerator.createNumber()))
            .collect(Collectors.toList());
        return new Cars(collect);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private Comparator<Car> carComparator() {
        return Comparator.comparing(Car::getPosition);
    }

    private Car selectMaxPositionCar() {
        return cars.stream()
            .max(carComparator())
            .orElseThrow(() -> new NoSuchElementException("최대 위치인 자동차가 존재하지 않습니다"));
    }

    public List<Car> selectWinners() {
        Car winner = selectMaxPositionCar();

        return cars.stream()
            .filter(car -> car.isSamePosition(winner))
            .collect(Collectors.toList());
    }
}
