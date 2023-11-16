package carracing.domain.game;

import carracing.domain.car.Cars;

public class RacingGame {
    private final Cars cars;
    private final int tryNumber;

    public RacingGame(Cars cars, int tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void race(MovingStrategy movingStrategy) {
        for (int i = 0; i < tryNumber; i++) {
            this.cars.race(movingStrategy);
        }
    }
}
