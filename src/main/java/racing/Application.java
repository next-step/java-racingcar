package racing;

import racing.controller.Game;
import racing.view.InputView;

public class Application {

    public static void main(String[] args) {
        int carCount = InputView.readCarCount();
        int tryCount = InputView.readTryCount();

        Game game = new Game(carCount, tryCount);
        game.race();
    }
}
