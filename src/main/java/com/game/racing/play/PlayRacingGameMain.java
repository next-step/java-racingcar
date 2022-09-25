package com.game.racing.play;

import com.game.racing.view.InputView;

public class PlayRacingGameMain {

    public static void main(String[] args) {
        PlayRacingGameMain playRacingGameMain = new PlayRacingGameMain();
        playRacingGameMain.playRacingGameByUserInput();
    }

    public void playRacingGameByUserInput() {
        RacingGame racingGame = new RacingGame();
        Integer carCount = InputView.inputCarCount();
        Integer tryCount = InputView.inputTryCount();
        racingGame.playRacingGame(carCount, tryCount);
    }
}
