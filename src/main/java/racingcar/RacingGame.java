package racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;
    private final ResultView resultView;
    private final WinnerCarSelector winnerCarSelector;

    public RacingGame(List<Car> cars, int tryCount, ResultView resultView, WinnerCarSelector winnerCarSelector) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.resultView = resultView;
        this.winnerCarSelector = winnerCarSelector;
    }

    public void process(Random random) {
        resultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            moveCars(this.cars, random);
            resultView.printCars(this.cars);
        }
        resultView.printWinners(winnerCarSelector.getWinnerCars(this.cars));
    }

    private void moveCars(List<Car> cars, Random random) {
        for (Car car : cars) {
            car.move(random);
        }
    }
}
