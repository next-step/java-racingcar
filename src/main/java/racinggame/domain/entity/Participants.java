package racinggame.domain.entity;

import racinggame.domain.movingstrategy.MovingStrategy;
import racinggame.domain.value.Location;

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
