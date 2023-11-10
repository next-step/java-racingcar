package racewinner.controller;


import racewinner.domain.CarRacing;
import racewinner.domain.Cars;
import racewinner.domain.CarsFactory;
import racewinner.view.InputView;
import racewinner.view.ResultView;

public class RaceApp {
    public static void main(String[] args) {
        final String carNameList = InputView.inputCarName();
        final int raceAttemptCount = InputView.inputRaceAttemptCount();

        final Cars cars = new CarsFactory().create(carNameList);
        final CarRacing carRacing = new CarRacing(cars, raceAttemptCount);

        while (!carRacing.isFinished()) {
            carRacing.race();
            ResultView.print(carRacing.toString());
        }

        ResultView.printWinner(carRacing.findWinners());
    }
}
