package racingGame;

import java.util.Random;
import java.util.Scanner;

public class RacingGame {
    private int[] carPosition;
    private int rounding;

    public RacingGame(int cars, int rounds) {
        this.carPosition = new int[cars];
        this.rounding = rounds;
    }

    public int[] racing() {
        for (int idx = 0; idx < rounding; idx++) {
            moveCar();
        }
        return carPosition;
    }

    private void moveCar() {
        for (int i = 0; i < carPosition.length; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(10);

            if (randomNum >= 4) {
                carPosition[i]++;
            }
            ResultView.printResult(carPosition[i]);
            System.out.println();
        }
        System.out.println();
    }
}
