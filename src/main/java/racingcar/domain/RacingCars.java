package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    public RacingCars(final List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<RacingCar> get() {
        return new ArrayList<>(racingCars);
    }
}
