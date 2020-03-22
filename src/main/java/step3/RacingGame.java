package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private int moveCount;
    private int carCount;
    private List<Integer> carPositions;
    private Random random = new Random();

    private static final int RANDOM_RANGE = 10;
    private static final int FORWARD_STATUS_VALUE = 4;
    private static final int FORWARD_VALUE = 1;
    private static final int STOP_VALUE = 0;

    public RacingGame() {
    }

    public RacingGame(int moveCount, int carCount) {
        this.moveCount = moveCount;
        this.carCount = carCount;
        initCarPosition();

    }

    public void initCarPosition() {
        carPositions = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carPositions.add(0);
        }
    }

    public void moveByRepeatCount() {
        for (int i = 0; i < moveCount; i++) {
            move();
        }
    }

    public void move() {
        for (int i = 0; i < carPositions.size(); i++) {
            Integer position = carPositions.get(i);
            position += forwardStatus(getRandomNumber());
            carPositions.set(i, position);
        }
    }

    public int getRandomNumber() {
        return random.nextInt(RANDOM_RANGE);
    }

    public int forwardStatus(int randomNumber) {
        if (randomNumber < FORWARD_STATUS_VALUE) {
            return STOP_VALUE;
        }
        return FORWARD_VALUE;
    }

    public List<Integer> getCarPositions() {
        return carPositions;
    }
}
