package step2;

import java.util.Random;

public class RacingGame {
    private int time;
    private int[] carPositions;

    public RacingGame(int trialNum, int carNum) {
        this.time = trialNum;
        this.carPositions = new int[carNum];
    }

    public void doGame() {
        ResultView resultView = new ResultView();
        resultView.printResultTitle();
        for (int i = 0; i < time; i++) {
            move();
            resultView.printCars(carPositions);
        }
    }

    private int[] move() {
        for (int i = 0; i < this.carPositions.length; i++) {
            if (getRandom() > 3) {
                this.carPositions[i]++;
            }
        }
        return carPositions;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(10);
    }

}
