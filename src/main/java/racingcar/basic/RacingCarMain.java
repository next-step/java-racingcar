package racingcar.basic;

import racingcar.basic.controller.GameController;

import static racingcar.basic.view.InputView.*;

public class RacingCarMain {

    public static void main(String[] args) {
        GameController game = new GameController(howManyCar(), howManyTry());
        game.playGame();
    }
}
