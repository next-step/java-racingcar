package racingcar;

import java.util.List;
import java.util.Random;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;
    private final ResultView resultView;

    public RacingGame(List<Car> cars, int tryCount, ResultView resultView) {
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
    }

    private void moveCars(List<Car> cars, Random random) {
        for (Car car : cars) {
            car.move(random);
        }
    }
}
