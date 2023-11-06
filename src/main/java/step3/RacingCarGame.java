package step3;

import java.sql.Array;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingCarGame {

    public static void main (String[] arg) {
        List<Integer> intput = InputView.display();
        int numCar = intput.get(0);
        int numAttempt = intput.get(1);

        Racing racingGame = new Racing(new int[numCar], numAttempt);
        racingGame.startGame();
    }
}
