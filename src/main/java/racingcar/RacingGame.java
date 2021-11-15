package racingcar;

import racingcar.view.ResultView;

public class RacingGame {

    private final int numOfTries;
    private Cars cars;

    public RacingGame(String carNames, int numOfTries) {
        this.cars = Cars.makeRacingCarsFromName(carNames);
        this.numOfTries = numOfTries;
    }

    public void racingGame() {

        ResultView.printStartResultView();

        for (int value = 1; value <= numOfTries; value++) {
            cars = racingOnce(cars);
        }

        ResultView.printWinnerView(cars.getWinnerCar());

    }

    private Cars racingOnce(Cars service) {
        Cars cars = service.doRacing();

        ResultView.printResultView(cars.getCars());

        return cars;
    }

}
