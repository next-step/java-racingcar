package step5.racingcar3.domain;

import java.util.Collections;
import java.util.stream.Collectors;

public class RacingGame {

    private final CarList cars;
    private final PositiveNumber numberOfRounds;

    public RacingGame(CarList cars, PositiveNumber numberOfRounds) {
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
    }

    public void start() {
        for (int i = 0; i < numberOfRounds.value(); i++) {
            cars.run();
        }
    }

    public void end() {
        // Do nothing
    }

    public CarList winners() {
        Position maxPosition = maxPosition();
        return new CarList(cars.value().stream().filter(car -> car.position().equals(maxPosition)).collect(Collectors.toList()));
    }

    private Position maxPosition() {
        return Collections.max(cars.value().stream().map(Car::position).collect(Collectors.toList()));
    }



}
