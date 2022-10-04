package com.game.racing;

import com.game.racing.controller.RacingGameController;

public class RacingGameApplication {

    public static void main(String[] args) {
        RacingGameApplication racingGameApplication = new RacingGameApplication();
        racingGameApplication.play();
    }

    public void play() {
        RacingGameController racingGameController = new RacingGameController();
        racingGameController.startRacingGame();
    }
}
