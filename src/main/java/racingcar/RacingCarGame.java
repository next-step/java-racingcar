package racingcar;

import java.util.List;

public class RacingCarGame {

    private final List<RacingCar> racingCars;

    public RacingCarGame(
        List<RacingCar> racingCars
    ) {
        this.racingCars = racingCars;
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            racingCar.goOrStop();
        }
    }
}
