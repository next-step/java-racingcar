package step3;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingGame {

    private int time;
    private int[] carPositions;
    private Random random = new Random();

    public RacingGame() {
    }

    public RacingGame(int moveCount, int carCount) {
        time = moveCount;
        carPositions = new int[carCount];
    }

    public void moveByRepeatCount() {
        IntStream.range(0, time).forEach(i -> {
            carPositions = move();
        });
    }

    public int[] move() {
        IntStream carPositionsStream = Arrays.stream(carPositions);
        return carPositionsStream.map(carPositions -> carPositions += findOutMove()).toArray();
    }

    public int findOutMove() {
        int randomNumber = randomNumber();
        return forwardStatus(randomNumber);
    }

    public int forwardStatus(int randomNumber) {
        if (randomNumber < 4) {
            return 0;
        }
        return 1;
    }

    public int randomNumber() {
        return random.nextInt(10);
    }

    public int[] getCarPositions() {
        return carPositions;
    }
}
