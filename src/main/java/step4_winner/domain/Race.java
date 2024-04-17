package step4_winner.domain;


import lombok.Getter;
import step4_winner.strategy.MovingStrategy;

import java.util.List;

@Getter
public class Race {
    private final List<Car> cars;

    public Race(List<Car> cars) {
        if (cars.isEmpty())
            throw new IllegalArgumentException("0이상이어야 함");
        this.cars = cars;
    }

    public void runRace(MovingStrategy movingStrategy) {
        cars.forEach(car -> car.move(movingStrategy));
    }
}
