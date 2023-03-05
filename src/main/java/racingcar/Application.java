package racingcar;

import racingcar.racing.RacingGame;

import static racingcar.view.Output.printErrorMessage;

public class Application {
    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame();
        try {
            racingGame.start();
        } catch (IllegalArgumentException e) {
            printErrorMessage(e.getMessage());
        }
    }
}
