package study.racingcar.controller;

import study.racingcar.domain.*;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

import java.util.List;

public class RandomGameController {
    public void start() {
        RacingGameData racingGameData = getRacingGameData();

        MovableDistance movableDistance = new RandomMovableDistance();
        RacingGame racingGame = new RacingGame(racingGameData, movableDistance);
        ResultView.displayStartGame();
        playRacingGame(racingGame);
        ResultView.displayGameResult(new RacingGameResult(racingGame));
    }

    private RacingGameData getRacingGameData() {
        List<String> carList = InputView.getCarList();
        int time = InputView.getTime();

        return new RacingGameData(carList, time);
    }

    private void playRacingGame(RacingGame racingGame) {
        while (racingGame.isMovable()) {
            racingGame.move();
            ResultView.displayGameStatus(racingGame);
        }
    }

}
