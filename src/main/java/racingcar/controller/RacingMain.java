package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.ui.RacingInputView;
import racingcar.ui.RacingResultView;

public class RacingMain {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(RacingInputView.carCount(), RacingInputView.raceTimes());
        while (!racingGame.isEndGame()) {
            RacingResultView.printResult(racingGame.start());
        }
    }
}
