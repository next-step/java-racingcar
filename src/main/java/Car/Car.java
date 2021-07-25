package Car;

import java.util.Random;

public class Car {
    private int moveCount;
    private Random random;

    private static final int NUMBER_BOUND = 10;
    private static final int MIN_MOVE_NUMBER = 4;

    public int getMoveCount() {
        return moveCount;
    }

    public Car() {
        moveCount = 0;
        random = new Random();
    }

    public void move() {
        int randomNumber = getRandomNumber();
        if (isMove(randomNumber)) {
            moveCount++;
        }
    }

    private int getRandomNumber() {
        return random.nextInt(NUMBER_BOUND);
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= MIN_MOVE_NUMBER;
    }
}
