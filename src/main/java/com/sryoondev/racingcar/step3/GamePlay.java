package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.InputView;
import com.sryoondev.racingcar.step3.view.ResultView;

public class GamePlay {
    public static void main(String[] args) {
        String[] names = InputView.getCarNames();
        int tryCount = InputView.getTryCount();
        RacingGame racingGame = new RacingGame(names, tryCount);
        GameRecord records = racingGame.start();
        ResultView.printGameRecord(records);
    }
}
