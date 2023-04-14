package racing;

import racing.view.OutputView;

public class RacingGame {

    private final Integer numberOfTry;

    private final Cars cars;

    public RacingGame(Integer numberOfTry, Cars cars) {
        this.numberOfTry = numberOfTry;
        this.cars = cars;
    }

    public void startGame(MoveStrategy moveStrategy) {
        for (int i = 0; i < numberOfTry; i++) {
            cars.move(moveStrategy);
            OutputView.outputProgress(cars);
        }
    }

}
