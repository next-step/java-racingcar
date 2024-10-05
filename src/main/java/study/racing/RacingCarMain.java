package study.racing;

import study.racing.game.RacingCarGame;
import study.racing.view.InputView;

public class RacingCarMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.validateCar(inputView.insertCar());
        inputView.validateGameCount(inputView.insertGameCount());

        RacingCarGame racingCarGame = new RacingCarGame(inputView);
        racingCarGame.play();
    }

}
