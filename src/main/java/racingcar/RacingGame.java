package racingcar;

import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private final int tryCount;
    private final ResultView resultView;
    private final CarsMover carsMover;

    public RacingGame(List<Car> cars, int tryCount, ResultView resultView, CarsMover carsMover) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.resultView = resultView;
        this.carsMover = carsMover;
    }

    public void process() {
        resultView.printResult();
        for (int i = 0; i < tryCount; i++) {
            carsMover.moveCars(this.cars);
            resultView.printCars(this.cars);
        }
    }
}
