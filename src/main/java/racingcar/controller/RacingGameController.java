package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.ResultView;

import java.util.InputMismatchException;

public class RacingGameController {

    public void RacingGameStart() {
        try {
            InputView inputView = new InputView();
            String cars = inputView.getInputCarNames();
            int time = inputView.getInputTime();

            RacingGame racingGame = new RacingGame(cars, time);
            racingGame.start();

            ResultView resultView = new ResultView(racingGame);
            resultView.printRacingGameWinner();

        } catch (
        InputMismatchException e) {
            System.out.println("숫자를 입력하세요");
        }
    }
}
