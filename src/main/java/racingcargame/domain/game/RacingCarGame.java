package racingcargame.domain.game;

import racingcargame.domain.vehicle.Cars;

public class RacingCarGame {

    private final int roundCount;

    private final Cars cars;

    public RacingCarGame(Cars cars, int roundCount) {
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public void playing() {
        cars.doDrive();
    }

    public int getRoundCount() {
        return roundCount;
    }

    public Cars getCars() {
        return cars;
    }
}
