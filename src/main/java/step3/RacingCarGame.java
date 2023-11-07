package step3;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

    public static void main (String[] arg) {
        List<Integer> input = InputView.display();
        int numCar = input.get(0);
        int numAttempt = input.get(1);
        Random random = new Random();

        Racing racingGame = new Racing();
        racingGame.gameSetup(numCar, numAttempt, random);

        racingGame.startGame();
    }
}
