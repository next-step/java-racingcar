package step3;

import java.util.Random;

public class RacingCarGame {

    public static void main (String[] arg) {
        InputView.display();
        Random random = new Random();

        GameSetup gameSetup = new GameSetup();
        gameSetup.setupGame(InputView.numCar, InputView.numAttempt, random);

        gameSetup.startGame();
    }
}
