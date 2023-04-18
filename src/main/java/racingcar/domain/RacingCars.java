package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCars;

    public RacingCars(String[] carNames) {
        this.racingCars = new ArrayList<>();

        for (int i = 0; i < carNames.length; i++) {
            this.racingCars.add(new RacingCar(carNames[i]));
        }
    }

    public List<RacingCar> statusOfRacingCars() {
        return this.racingCars;
    }
}
