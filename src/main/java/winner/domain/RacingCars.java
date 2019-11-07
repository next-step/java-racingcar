package winner.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-01 22:54
 */
public class RacingCars {

    private static final String DELIMITER = ", ";
    private List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(car -> car.move(new CarMoveStrategy()));
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.isMaxPosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER));
    }

    private int findMaxPosition() {
        return cars.stream().map(car -> car.getPositionToText()).max(Integer::compareTo).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingCars that = (RacingCars) o;
        return Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
