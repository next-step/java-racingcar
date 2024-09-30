package racingcar;

import racingcar.controller.GameController;

import static racingcar.view.InputView.*;

public class RacingCarMain {

    public static void main(String[] args) {
        GameController game = new GameController(howManyCar(), howManyTry());
        game.playGame();
    }
}
