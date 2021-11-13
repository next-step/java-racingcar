package com.sryoondev.racingcar.step3;

import com.sryoondev.racingcar.step3.view.InputView;
import com.sryoondev.racingcar.step3.view.ResultView;

public class GamePlay {
    public static void main(String[] args) {
        int carCount = InputView.getCarCount();
        int tryCount = InputView.getTryCount();
        ResultView.drawTitle();
        RacingGame racingGame = new RacingGame(carCount, tryCount);
        racingGame.start();
    }
}
