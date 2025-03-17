package racingcar;

import java.util.Random;

public class RacingGame {

    private final Cars cars;
    private final int tryCount;
    private final ResultView resultView;

    public RacingGame(Cars cars, int tryCount, ResultView resultView) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.resultView = resultView;
    }

    public void process(Random random) {
        resultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            moveCars(this.cars, random);
            resultView.printCars(this.cars);
        }
        resultView.printWinners(cars);
    }

    private void moveCars(Cars cars, Random random) {
        cars.moveAll(random);
    }
}
