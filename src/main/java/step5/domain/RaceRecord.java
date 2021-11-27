package step5.domain;

import step5.dto.Car;
import step5.dto.CarName;
import step5.dto.CarNames;
import step5.dto.Position;

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

    public List<Car> findWinners() {
        Position maxPosition = findMaxPosition();

        return carGroup.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                //.map((car) -> new CarName(car.getName()))
                .collect(Collectors.toList());
    }

    private Position findMaxPosition() {
        return carGroup.stream()
                .map(Car::getPosition)
                .max(Comparator.comparing(Position::getCurrentPosition))
                .orElse(new Position());
    }
}
