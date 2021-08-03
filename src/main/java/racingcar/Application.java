package racingcar;

import racingcar.domain.GameController;

public class Application {
    public static void main(String[] args) {
        GameController game = new GameController();
        game.gameStart();
    }
}
