package step5;

import step5.View.InputView;

public class App {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame(new InputView());

        racingGame.start();
    }
}
