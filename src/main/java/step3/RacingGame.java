package step3;

import java.util.Random;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public RacingGame(int time, int carCount) {
        this.time = time;
        this.carPositions = new int[carCount];
    }

    public int[] move() {
        for (int i = 0; i < this.carPositions.length; ++i) {
            if (getRandomPosition() >= 4) {
                this.carPositions[i]++;
            }
        }

        return this.carPositions;
    }

    public Integer getRandomPosition() {
        return new Random().nextInt(10);
    }
}
