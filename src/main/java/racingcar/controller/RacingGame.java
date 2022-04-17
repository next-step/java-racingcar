package racingcar.controller;

import racingcar.model.Cars;

public class RacingGame {
    private final int tryCount;

    private int movedCount = 0;

    public RacingGame(int tryCount) {
        this.tryCount = tryCount;
    }

    public boolean end() {
        return this.movedCount >= this.tryCount;
    }

    public void race(Cars cars) {
        cars.move();
        increaseMovedCount();
    }

    private synchronized void increaseMovedCount() {
        this.movedCount++;
    }
}
