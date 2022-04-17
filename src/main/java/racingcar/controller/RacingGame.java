package racingcar.controller;

import racingcar.model.Cars;

public class RacingGame {
    private final int carMoveCount;
    private int carMovedCount = 0;

    public RacingGame(int carMoveCount) {
        this.carMoveCount = carMoveCount;
    }

    public boolean end() {
        return this.carMovedCount >= this.carMoveCount;
    }

    public void race(Cars cars) {
        cars.move();
        increaseCarMoveCount();
    }

    private synchronized void increaseCarMoveCount() {
        this.carMovedCount++;
    }
}
