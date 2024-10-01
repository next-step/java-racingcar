package study.racing;

import study.racing.game.RacingCarGame;
import study.racing.ui.InputView;

public class RacingCarMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.validateCarCount(inputView.insertCarCount());
        inputView.validateGameCount(inputView.insertGameCount());

        RacingCarGame racingCarGame = new RacingCarGame(inputView);
        racingCarGame.play();
    }

}
