package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame{

    private final RacingCars racingCars;
    private final int raceCount;

    public RacingGame(final RacingCars racingCars, final int raceCount) {
        this.racingCars = racingCars;
        this.raceCount = raceCount;
    }

    public List<RacingCars> moveForwardAll(final Movable movable) {
        final List<RacingCars> histories = new ArrayList<>();
        RacingCars cars = racingCars;
        for (int count = 0; count < raceCount; count++) {
            cars = cars.race(movable);
            histories.add(cars);
        }
        return histories;
    }

}
