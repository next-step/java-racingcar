package racing_refactoring.domain;

public class RacingGame {

    private final RacingCars racingCars;
    private final MovementCount movementCount;

    public RacingGame(RacingCars racingCars, int movementCount) {
        this(racingCars, new MovementCount(movementCount));
    }

    private RacingGame(RacingCars racingCars, MovementCount movementCount) {
        this.racingCars = racingCars;
        this.movementCount = movementCount;
    }

    public RacingCars racing() {
        for (int i = 0; i < this.racingCars.size(); i++) {
            racingCars.move(i);
        }
        return racingCars;
    }
}
