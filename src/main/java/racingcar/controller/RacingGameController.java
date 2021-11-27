package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        List<Car> cars = inputView.inputCarNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
        int lastRound = inputView.inputLastRound();
        RacingGame racingGame = new RacingGame(cars);

        IntStream.range(0, lastRound)
                .forEach(i -> {
                    racingGame.play();
                    resultView.showResult(racingGame.getCars());
                });
        resultView.showWinners(racingGame.getWinners());
    }
}
