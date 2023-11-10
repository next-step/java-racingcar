package racewinner.controller;


import racewinner.domain.CarRacing;
import racewinner.util.RandomGenerator;
import racewinner.view.InputView;
import racewinner.view.ResultView;

public class RaceApp {
    public static void main(String[] args) {
        final String carNameList = InputView.inputCarName();
        final int raceAttemptCount = InputView.inputRaceAttemptCount();

        final CarRacing carRacing = new CarRacing(carNameList, raceAttemptCount, new RandomGenerator());

        while (!carRacing.isFinished()) {
            carRacing.race();
            ResultView.print(carRacing.toString());
        }

        ResultView.printWinner(carRacing.findWinners());
    }
}
