package study.racing.controller;

import study.racing.domain.CarRacing;
import study.racing.domain.RacingRecords;
import study.racing.domain.RandomMoveStrategy;
import study.racing.view.InputView;
import study.racing.view.ResultView;

public class CarRacingController {

    public static String[] getCarsName() {
        return InputView.getCarsName();
    }

    public static int getTryCount() {
        return InputView.getTryCount();
    }

    public static RacingRecords execute(String[] carNames, int tryCount) {
        CarRacing carRacing = new CarRacing(new RandomMoveStrategy());
        return carRacing.start(carNames, tryCount);
    }

    public static void showResult(RacingRecords racingResults) {
        ResultView.showResultHead();
        ResultView.showResult(racingResults);
    }
}
