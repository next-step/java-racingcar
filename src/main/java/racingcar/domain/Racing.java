package racingcar.domain;

import racingcar.strategy.NormalMoveStrategy;
import racingcar.strategy.MoveStrategy;

import java.util.List;

public class Racing {
    private RacingCars cars;

    public Racing(RacingCars racingCars) {
        this.cars = racingCars;
    }

    public void runRacingRound(MoveStrategy moveStrategy) {
        this.cars.tryToRacingRound(moveStrategy);
    }

    public List<RacingCar> statusOfRacing() {
        return this.cars.statusOfRacingCars();
    }
}