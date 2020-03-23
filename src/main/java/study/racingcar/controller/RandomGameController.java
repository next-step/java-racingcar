package study.racingcar.controller;

import study.racingcar.domain.Car;
import study.racingcar.domain.MovableDistance;
import study.racingcar.domain.RacingGame;
import study.racingcar.domain.RacingGameData;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RandomGameController {
    // todo static 으로 하는것이 좋을까?
    public void start() {
        List<String> carList = InputView.getCarList();
        int time = InputView.getTime();

        if (!validate(carList, time)) {
            ResultView.displayInvalidInputError();
            return;
        }

        MovableDistance movableDistance = new RandomMovableDistance();
        RacingGame racingGame =
                new RacingGame(new RacingGameData(carList, time),
                        movableDistance);
        ResultView.displayStartGame();

        while (racingGame.isMovable()) {
            racingGame.move();
            ResultView.displayGameStatus(racingGame);
        }

        List<Car> winners = racingGame.getWinner();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
        ResultView.displayWinners(winnerNames);
    }

    private boolean validate(List<String> carNames, int time) {
        if (Objects.isNull(carNames) || carNames.isEmpty()) {
            return false;
        }

        return time >= 1;
    }
}
