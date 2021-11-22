package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.stream.IntStream;

public class RacingGameController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        RacingGame racingGame = new RacingGame(inputView.input());

        IntStream.range(0, racingGame.getLastRound())
                .forEach(i -> {
                    racingGame.play();
                    resultView.showResult(racingGame.getCurrentStatus());
                });
    }
}
