package study.step3;

import study.step3.game.RacingCarGame;
import study.step3.ui.InputView;

public class RacingCarMain {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.validateCarCount(inputView.insertCarCount());
        inputView.validateGameCount(inputView.insertGameCount());

        RacingCarGame racingCarGame = new RacingCarGame(inputView);
        racingCarGame.play();
    }

}
