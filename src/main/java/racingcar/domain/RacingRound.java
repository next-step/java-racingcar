package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingRound {
    private final List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> racingCars) {
        this.racingCars = new ArrayList<>(racingCars);
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
