package study.racingcar;

import java.util.Random;

public class RacingGame {
    private int time;
    private int[] carPositions;

    public RacingGame(RacingGameData racingGameData) {
        carPositions = new int[racingGameData.getNumberOfCar()];
        this.time = racingGameData.getTime();
    }

    public int[] move() {
        if (!isMovable()) {
            return carPositions;
        }
        time--;

        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] += getDistanceToMove();
        }

        return carPositions;
    }

    public boolean isMovable() {
        return time != 0;
    }

    private int getDistanceToMove() {
        int random = (new Random()).nextInt(10);
        return (random >= 4) ? 1 : 0;
    }
}
