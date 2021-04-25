package step5.controller;

import step5.domain.*;
import step5.view.InputView;
import step5.view.ResultView;

import java.util.stream.IntStream;

public class RacingCarController {

    private RandomNo randomNo = new RandomNoImpl();
    private RacingGame racingGame = new RacingGame();
    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private InputDto input;

    public void init() {
        input = inputView.getInput();

        input.getNameList().forEach(name -> racingGame.addRacingCar(new RacingCar(name)));
    }

    private void playGame() {
        racingGame.getCarList().forEach(car -> car.run(randomNo));
        resultView.printResult(racingGame);
    }

    public void startGame() {
        resultView.printStart();
        int trial = input.getTrial();

        IntStream.rangeClosed(1, trial).forEach(i -> playGame());
    }

    public void findWinner() {
        resultView.printWinner(racingGame);
    }
}