package step5.racingcar.domain;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class CarGroups {

    private final List<Car> carGroups;

    public CarGroups(List<Car> carGroups) {
        this.carGroups = carGroups;
    }

    public void move() {
        carGroups.forEach(Car::move);
    }

    public List<String> getCarNames() {
        return carGroups.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getCarPositions() {
        return carGroups.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerCarNames() {
        int maxPosition = getMaxPosition();
        return carGroups.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        Car car = carGroups.stream()
                .max(Comparator.comparing(Car::getPosition))
                .orElseThrow(() -> new NoSuchElementException(Message.ERROR_MAX_POSITION));
        return car.getPosition();
    }
}
