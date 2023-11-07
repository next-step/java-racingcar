package racewinner.controller;


import racewinner.domain.CarRacing;
import racewinner.strategy.RandomMoveStrategy;
import racewinner.view.InputView;

public class RaceApp {
    public static void main(String[] args) {
        final String carNameList = InputView.inputCarName();
        final int raceAttemptCount = InputView.inputRaceAttemptCount();

        final CarRacing carRacing = new CarRacing(carNameList, new RandomMoveStrategy());
        carRacing.start(raceAttemptCount);
    }
}
