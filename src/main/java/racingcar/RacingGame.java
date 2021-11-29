package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.view.ResultView;

public class RacingGame {

    private final int numOfTries;
    private final Cars cars;

    public RacingGame(String carNames, int numOfTries) {
        this.cars = Cars.makeRacingCarsFromName(carNames);
        this.numOfTries = numOfTries;
    }

    public void racingGame(MoveStrategy moveStrategy) {

        ResultView.printStartResultView();

        for (int value = 1; value <= numOfTries; value++) {
            cars.doRacing(moveStrategy);
            ResultView.printResultView(cars.getCars());
        }

        ResultView.printWinnerView(cars.getWinnerCar());

    }

}
