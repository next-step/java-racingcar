package step3;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    public static void main (String[] arg) {
        InputView.display();
        Random random = new Random();

        Racing racingGame = new Racing();
        racingGame.setupGame(InputView.numCar, InputView.numAttempt, random);

        racingGame.startGame();
    }
}
