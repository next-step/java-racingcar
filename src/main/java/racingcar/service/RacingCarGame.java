package racingcar.service;

import exception.NegativeNumberException;
import racingcar.domain.Cars;
import racingcar.strategy.MovingStrategy;
import racingcar.view.ResultView;

public class RacingCarGame {

    private int carCount;
    private int tryCount;

    private RacingCarGame() {
    }

    public RacingCarGame(int carCount, int tryCount) {
        this.carCount = validationPositiveNumber(carCount);
        this.tryCount = validationPositiveNumber(tryCount);
    }

    public void play(MovingStrategy movingStrategy) {
        Cars cars = new Cars(carCount);
        for (int i = 0; i < tryCount; i++) {
            cars.move(movingStrategy);
            ResultView.print(cars);
        }
    }

    private int validationPositiveNumber(int value) {
        if(value < 0) {
            throw new NegativeNumberException();
        }
        return value;
    }
}
