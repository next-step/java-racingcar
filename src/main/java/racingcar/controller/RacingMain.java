package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.ui.RacingInputView;
import racingcar.ui.RacingResultView;

public class RacingMain {

    public static void main(String[] args) {
        int carCount = RacingInputView.carCount();
        int tryCount = RacingInputView.raceTimes();

        RacingGame racingGame = new RacingGame(carCount, tryCount);
        Cars cars = racingGame.initRacing();
        while (!racingGame.isEndGame()) {
            racingGame.start();
            RacingResultView.printResult(cars);
        }

    }
}
