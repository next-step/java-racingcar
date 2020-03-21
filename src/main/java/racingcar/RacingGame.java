package racingcar;

import racingcar.view.ResultView;

import java.util.Random;

public class RacingGame {
    private int[] carPositions;
    private int raceTime;
    private Random random = new Random();
    private static final int MOVABLE_NUMBER = 3;

    public RacingGame(int carNumber, int raceTime) {
        this.carPositions = new int[carNumber];
        this.raceTime = raceTime;
    }

    public int[] racing() {
        while (racingFlag()) {
            moveCar();
            reduceCount();
        }
        return carPositions;
    }

    private boolean racingFlag() {
        return this.raceTime > 0;
    }

    private void moveCar() {
        for (int i = 0; i < carPositions.length; i++) {
            if (movable()) {
                carPositions[i]++;
            }
            ResultView.printResultView(carPositions[i]);
            ResultView.nextLine();
        }
        ResultView.nextLine();
    }

    private void reduceCount() {
        this.raceTime = raceTime-1;
    }

    private boolean movable() {
        return random.nextInt() > MOVABLE_NUMBER;
    }

}
