package racingcar;

import racingcar.domain.Cars;
import racingcar.view.ResultView;

public class RacingGame {

    private final int numOfTries;
    private final Cars cars;

    public RacingGame(String carNames, int numOfTries) {
        this.cars = Cars.makeRacingCarsFromName(carNames);
        this.numOfTries = numOfTries;
    }

    public void racingGame() {

        ResultView.printStartResultView();

        for (int value = 1; value <= numOfTries; value++) {
            cars.doRacing();
            ResultView.printResultView(cars.getCars());
        }

        ResultView.printWinnerView(cars.getWinnerCar());

    }

}
