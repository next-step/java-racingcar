package step6.domain;

import step6.view.ResultView;

public class RacingGame {
    private final Cars cars;
    private final TryNumber tryNumber;

    public RacingGame(Cars cars, TryNumber tryNumber) {
        this.cars = cars;
        this.tryNumber = tryNumber;
    }

    public void run() {
        ResultView.printResultGuideMessage();
        ResultView.printCurrentPosition(cars);
        while (!tryNumber.finish()) {
            cars.runRacingGame(tryNumber);
            ResultView.printCurrentPosition(cars);
            tryNumber.minus();
        }
    }
}
