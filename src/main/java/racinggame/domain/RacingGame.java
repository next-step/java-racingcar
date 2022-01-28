package racinggame.domain;

import java.util.List;

public class RacingGame {

    private static final int RANGE_OF_RANDOM_NUMBER = 9 - 0 + 1;

    private List<RacingCar> racingCars;

    public RacingGame() {}

    public RacingGame(List<RacingCar> racingCars) {
        Validator.validatePossibleToStart(racingCars);
        this.racingCars = racingCars;
    }

    public void progress() {
        racingCars.forEach(car -> {
            int randomValue = getRandomValue();
            if (car.canForward(randomValue)) {
                car.forward();
            }
        });
    }

    public int getRandomValue() {
        return (int) Math.floor(Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    public List<RacingCar> getRacingCars() {
        return this.racingCars;
    }
}
