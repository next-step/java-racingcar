package racewinner;


import racewinner.strategy.RandomMoveStrategy;
import racewinner.ui.InputView;

public class RaceApp {
    public static void main(String[] args) {
        final String carNameList = InputView.inputCarName();
        final int raceAttemptCount = InputView.inputRaceAttemptCount();

        final CarRacing carRacing = new CarRacing(carNameList, new RandomMoveStrategy());
        carRacing.start(raceAttemptCount);

    }
}
