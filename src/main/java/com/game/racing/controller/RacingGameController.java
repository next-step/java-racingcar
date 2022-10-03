package com.game.racing.controller;

import com.game.racing.service.RacingGameService;
import com.game.racing.view.InputView;

public class RacingGameController {

    private final RacingGameService racingGameService;

    public RacingGameController() {
        String[] carNames = InputView.inputCarNames();
        Integer tryCount = InputView.inputTryCount();
        racingGameService = new RacingGameService(carNames, tryCount);
    }

    public void startRacingGame() {
        racingGameService.playRacingGame();
    }

}
