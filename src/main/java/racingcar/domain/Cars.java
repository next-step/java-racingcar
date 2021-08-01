package racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        checkNullOrEmpty(cars);
        this.cars = cars;
    }

    private void checkNullOrEmpty(List<Car> cars) {
        if(Objects.isNull(cars) || cars.isEmpty()) {
            throw new IllegalArgumentException("차는 최소 1대 이상이어야 합니다.");
        }
    }

    public void moveCars(MovableStrategy movableStrategy) {
        cars.stream().forEach(car -> car.move(movableStrategy));
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> findWinners() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.isSame(maxPosition))
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        return cars.stream()
                .max(Comparator.comparingInt(car -> car.getPosition().getPosition()))
                .orElseThrow(NoSuchElementException::new)
                .getPosition();
    }
}
