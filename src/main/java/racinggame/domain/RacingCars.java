package racinggame.domain;

import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = Collections.unmodifiableList(racingCars);
    }

    public int size() {
        return racingCars.size();
    }
}
