package study.racingcar.controller;

import study.racingcar.domain.*;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class RandomGameController {
    public void start() {
        RacingGameData racingGameData = getRacingGameData();

        MovableDistance movableDistance = new RandomMovableDistance();
        RacingGame racingGame = new RacingGame(racingGameData, movableDistance);
        ResultView.displayStartGame();
        playRacingGame(racingGame);
        displayWinner(racingGame);
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

    private void displayWinner(RacingGame racingGame) {
        RacingGameResult racingGameResult =
                new RacingGameResult(racingGame);
        List<Car> winners = racingGameResult.getWinner();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        ResultView.displayWinners(winnerNames);
    }
}
