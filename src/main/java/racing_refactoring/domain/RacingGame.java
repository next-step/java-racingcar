package racing_refactoring.domain;

public class RacingGame {
    private final RacingCars racingCars;

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public RacingCars racing(MovingStrategy movingStrategy) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            racingCar.move(movingStrategy);
        }
        return racingCars;
    }
}
