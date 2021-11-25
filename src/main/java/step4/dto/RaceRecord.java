package step4.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceRecord {

    private final List<Car> carGroup;

    public RaceRecord(List<Car> carGroup) {
        this.carGroup = new ArrayList<>(carGroup);
    }

    public List<Car> getRaceRecord() {
        return Collections.unmodifiableList(carGroup);
    }

    public List<CarName> findWinners() {
        return carGroup.stream()
                .filter(car -> car.getPosition().equals(findMaxPosition()))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private Position findMaxPosition() {
        return carGroup.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(Position::getPosition))
                .orElse(new Position());
    }
}
