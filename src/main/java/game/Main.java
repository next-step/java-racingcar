package game;

import game.view.input.Input;

public class Main {

    public static void main(String[] args) {
        RacingGameController racingGameController
                = new RacingGameController(4, 10, Input.inputNames(), Input.inputNumber());
        racingGameController.startGame();
    }
}
