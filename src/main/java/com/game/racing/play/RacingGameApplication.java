package com.game.racing.play;

import com.game.racing.view.InputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = new RacingGameApplication();
        racingGameApplication.playRacingGameByUserInput();
    }

    public void playRacingGameByUserInput() {
        RacingGame racingGame = new RacingGame();
        String carNames = InputView.inputCarNames();
        Integer tryCount = InputView.inputTryCount();
        racingGame.play(carNames, tryCount);
    }
}
