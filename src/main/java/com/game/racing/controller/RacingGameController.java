package com.game.racing.controller;

import com.game.racing.domain.car.Winner;
import com.game.racing.domain.car.Cars;
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
        Cars cars = racingGameService.playRacingGame();
        Winner winner = new Winner(cars);
        winner.printWinnersAndGetWinnersSize();
    }

}
