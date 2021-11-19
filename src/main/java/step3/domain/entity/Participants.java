package step3.domain.entity;

import step3.domain.movingstrategy.MovingStrategy;
import step3.domain.value.Location;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Car> cars;

    public Participants(List<Car> cars) {
        this.cars = cars;
    }

    public List<Location> play(MovingStrategy movingStrategy) {
        return cars.stream()
                .map(c -> c.play(movingStrategy))
                .collect(Collectors.toList());
    }
}
