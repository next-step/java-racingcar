package racinggame.domain;

public class RacingGame {

    private static final int RANGE_OF_RANDOM_NUMBER = 9 - 0 + 1;

    private RacingCars racingCars;

    public RacingGame() {}

    public RacingGame(final RacingCars racingCars) {
        Validator.validatePossibleToStart(racingCars);
        this.racingCars = racingCars;
    }

    public void progress() {
        racingCars.get().forEach(car -> car.forward(getRandomValue()));
    }

    public int getRandomValue() {
        return (int) Math.floor(Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    public RacingCars getRacingCars() {
        return this.racingCars;
    }
}

