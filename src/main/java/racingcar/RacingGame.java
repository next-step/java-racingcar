package racingcar;

import racingcar.view.ResultView;

import java.util.List;

public class RacingGame {

    private List<Car> racingCars;
    private final int numOfTries;
    private final CarService carService;
    private final ResultView resultView;

    public RacingGame(String carNames, int numOfTries) {
        this.racingCars = CarService.makeRacingCarsFromName(carNames);
        this.numOfTries = numOfTries;
        this.carService = new CarService();
        this.resultView = new ResultView();
    }

    public void racingGame() {

        resultView.printStartResultView();

        for (int value = 1; value <= numOfTries; value++) {
            racingOnce();
        }

        List<Car> winner = carService.getWinnerCar(racingCars);
        resultView.printWinnerView(winner);

    }

    private void racingOnce() {
        racingCars = new Racing(racingCars).doRacing();
        resultView.printResultView(racingCars);
    }

}
