package racingcar.domain;

import java.util.Collections;
import java.util.List;

public class RacingRound {
    private List<RacingCar> racingCars;

    public RacingRound(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }
}
