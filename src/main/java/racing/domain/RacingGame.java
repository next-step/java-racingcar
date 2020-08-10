package racing.domain;

import racing.view.ResultView;

import static racing.view.InputView.getNumberOfAttempt;
import static racing.view.InputView.getNumberOfCars;
import static racing.view.ResultView.printRacingGameResult;

public class RacingGame {

    public void start() {
        final int numberOfCar = getNumberOfCars();
        final int numberOfAttempt = getNumberOfAttempt();

        printRacingGameResult();
        final RacingCars racingCars = RacingCars.of(numberOfCar);
        for (int i = 0; i < numberOfAttempt; i++) {
            ResultView.printLocationsByCars(racingCars.raceOfCars(racingCars.getCars()));
        }
    }
}
