package com.kakao.racingcar;

import com.kakao.racingcar.domain.RacingGame;
import com.kakao.racingcar.ui.InputView;
import com.kakao.racingcar.ui.OutputView;

public class Runner {
    public static void main(String args[]) {
        InputView inputView = new InputView(System.in);
        int carTotal = inputView.inputCarTotal();
        int tryCount = inputView.inputTryCount();
        RacingGame racingGame = new RacingGame(tryCount, carTotal);
        racingGame.runRace();
        OutputView.printRacingGame(racingGame.getRacingHistory());
    }
}
