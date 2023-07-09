package car.domain;

import car.util.NumberGenerator;
import java.util.Collections;
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

    public void race(final NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.createNumber());
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> selectWinners() {
        int carMaxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new NoSuchElementException("자동차 간의 최대 위치가 존재 하지 않습니다."));

        return cars.stream()
            .filter(car -> car.isSamePosition(carMaxPosition))
            .collect(Collectors.toList());
    }
}
