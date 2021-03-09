package step3;

import step3.controller.RacingCarGame;
import step3.view.InputView;
import step3.view.ResultView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarGame racingCarGame = new RacingCarGame(inputView.inputCar(), inputView.inputAttempt());
        new ResultView().print(racingCarGame);
    }
}
