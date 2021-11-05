package racingcar.step3.service;

import racingcar.step3.domain.Cars;
import racingcar.step3.move.Moving;

public class RacingGame {

    private int countOfTry;
    private Cars cars;

    public RacingGame(int countOfTry, Cars cars) {
        this.countOfTry = countOfTry;
        this.cars = cars;
    }

    public boolean isEndGame() {
        return countOfTry == 0;
    }

    public void race(Moving moving) {
        cars.moveCars(moving);
        countOfTry--;
    }

    public int getCountOfTry() {
        return countOfTry;
    }
}
