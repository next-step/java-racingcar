package racingcar;

import java.util.List;
import java.util.Random;

public class RacingCarGame {
    private final List<Car> carList;
    private final int tryCount;
    private final ResultView resultView;

    public RacingCarGame(List<Car> carList, int tryCount, ResultView resultView) {
        this.carList = carList;
        this.tryCount = tryCount;
        this.resultView = resultView;
    }

    public void startGame(Random random) {
        resultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            moveCars(this.carList, random);
            resultView.printCars(this.carList);
        }
    }

    private void moveCars(List<Car> carList, Random random) {
        for (Car car : carList) {
            car.move(random);
        }
    }
}
