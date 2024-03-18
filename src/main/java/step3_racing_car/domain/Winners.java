package step3_racing_car.domain;

import java.util.List;

public class Winners {
    RacingCars racingCars;

    public Winners(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<String> findWinners() {
        int maxPosition = this.racingCars.maxPositionValue();
        return this.racingCars.matchPositionList(maxPosition).getNames();
    }
}
