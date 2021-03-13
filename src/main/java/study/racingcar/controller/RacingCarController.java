package study.racingcar.controller;

import study.racingcar.domain.RacingCarGame;
import study.racingcar.view.InputView;
import study.racingcar.view.ResultView;

public class RacingCarController {
    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public void start() {

        String nameOfCars = inputView.enterNameOfCars().trim();
        int numberOfAttempts = inputView.enterNumberOfAttempts();

        RacingCarGame racingCarGame = new RacingCarGame(nameOfCars.split(","), numberOfAttempts);

        resultView.printStart();

        while(racingCarGame.racingAttemptsCheck()) {
            racingCarGame.racing();
            resultView.print(racingCarGame.getRacingCars());
        }

        resultView.printsWinner(racingCarGame.getRacingPrintInfo());
    }


}
