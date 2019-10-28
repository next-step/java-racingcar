package step2;

import java.util.Random;

public class RacingGame {
    private int time;
    private int[] carPositions = {0, 0, 0};

    public RacingGame(int time) {
        this.time = time;
    }

    public void move() {
        // TODO 구현
        int randomNumber = generateRandom();
    }

    public int generateRandom() {
        Random random = new Random();
        int randomNumber = random.nextInt(10);

        return randomNumber;
    }
}