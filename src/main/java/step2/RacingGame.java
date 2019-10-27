package step2;

import java.util.Random;

public class RacingGame {

    private int time;
    private int[] carPositions;

    public RacingGame() {

    }

    public int[] carPositionsInitiate(int createCarCount) {
        this.carPositions = new int[createCarCount];
        for (int i = 0; i < carPositions.length; i++) {
            carPositions[i] = 0;
        }
        return carPositions;
    }

    public int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public boolean isMove() {
        if (getRandomNumber() >= 4) {
            return true;
        }
        return false;
    }


}
