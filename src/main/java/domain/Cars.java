package domain;

import util.MoveStrategy;

import java.util.*;
import java.util.stream.Collectors;

public class Cars {
    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public Cars(String name) {
        cars = Arrays.stream(name.split(DELIMITER))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> moveCars(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
        return cars.stream()
                .collect(Collectors.toMap(Car::getName, car -> car.getPosition().getPosition()));
    }

    public List<Car> findWinners() {
        Position maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.equalPosition(maxPosition))
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("우승자가 없습니다."));
    }
}
