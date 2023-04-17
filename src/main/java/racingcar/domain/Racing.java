package racingcar.domain;

import racingcar.strategy.MoveStrategy;

import java.util.List;

public class Racing {
    private RacingCars cars;

    public Racing(RacingCars racingCars) {
        this.cars = racingCars;
    }

    public void startRacingRound(MoveStrategy moveStrategy) {
        this.cars.runRacingRound(moveStrategy);
    }

    public List<RacingCar> statusOfRacing() {
        return this.cars.statusOfRacingCars();
    }
}