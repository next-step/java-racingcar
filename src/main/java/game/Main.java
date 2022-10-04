package game;

import game.view.input.Input;
import game.view.input.RacingGameInput;

public class Main {

    public static void main(String[] args) {
        RacingGameController racingGameController
                = new RacingGameController(
                        4,
                10,
                RacingGameInput.inputCarNames(),
                RacingGameInput.inputNumberOfRound());
        racingGameController.startGame();
    }
}
