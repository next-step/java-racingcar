package car.domain;

import car.util.NumberGenerator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public final class Cars {

    private final List<Car> cars;

    public Cars(final List<CarName> carNames) {
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }
    public Cars(final CarNames carNames) {
        cars = carNames.getCarNames().stream()
            .map(car -> new Car(car.getName()))
            .collect(Collectors.toList());
    }

    public void race(final NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.createNumber());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private Comparator<Car> carComparator() {
        Comparator<Car> comparatorCar = Comparator.comparing(Car::getPosition);
        return comparatorCar;
    }

    private Car selectMaxPositionCar() {
        Car car = cars.stream()
            .max(carComparator())
            .orElseThrow(() -> new NoSuchElementException("최대 위치인 자동차가 존재하지 않습니다"));
        return car;
    }

    public List<Car> selectWinners() {
        Car winner = selectMaxPositionCar();

        return cars.stream()
            .filter(car -> car.isSamePosition(winner))
            .collect(Collectors.toList());
    }
}
