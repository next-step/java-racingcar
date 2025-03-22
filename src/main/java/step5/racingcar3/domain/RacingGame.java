package step5.racingcar3.domain;

import java.util.Collections;
import java.util.stream.Collectors;

public class RacingGame {

    private final CarList cars;

    public RacingGame(CarList cars) {
        this.cars = cars;
    }

    public void start() {
        cars.run();
    }

    public void end() {
        // Do nothing
    }

}
