package com.game.racing.play;

import com.game.racing.view.InputView;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = new RacingGameApplication();
        racingGameApplication.playRacingGameByUserInput();
    }

    public void playRacingGameByUserInput() {
        RacingGame racingGame = new RacingGame();
        Integer carCount = InputView.inputCarCount();
        Integer tryCount = InputView.inputTryCount();
        racingGame.play(carCount, tryCount);
    }
}
