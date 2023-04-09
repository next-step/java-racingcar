package racingcar;

import java.util.List;

public class RacingCarGame {

    private final List<RacingCar> racingCars;
    private final RandomStrategy strategy;

    public RacingCarGame(
        List<RacingCar> racingCars,
        RandomStrategy strategy
    ) {
        this.racingCars = racingCars;
        this.strategy = strategy;
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.goOrStop(NumberRange.getOne(strategy));
        }
    }
}
