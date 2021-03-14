package dev.djoon.racingcar.controller;

import dev.djoon.racingcar.domain.RacingCarGame;
import dev.djoon.racingcar.domain.util.RandomNumbers;
import dev.djoon.racingcar.view.InputView;
import dev.djoon.racingcar.view.ResultView;

import java.util.List;

public class GameController {
    private List<String> carOwnerNames;
    private int loopTimes;

    public void inputGameInfo() {
        InputView inputView = new InputView(System.in);
        this.carOwnerNames = inputView.inputCarWithOwner();
        this.loopTimes = inputView.inputLoopTimes();
        inputView.close();
    }

    public void start() {
        RacingCarGame game = new RacingCarGame(carOwnerNames, new RandomNumbers());

        ResultView.printNewGame();
        for (int i = 0; i < loopTimes; i++) {
            game.start();
            ResultView.printRoundResult(game.getCarList());
        }
        ResultView.printWinner(game.findWinners());
    }

}
