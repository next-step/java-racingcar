package step3.model;

import java.util.Random;

public class Car {
    private static final int MOVE_MIN_NUMBER = 4;
    private static final int RANDOM_MAX_NUMBER = 10;
    private static final Random RANDOM = new Random();

    private int moveCount;
    private final String name;

    public Car(final String name) {
        this.name = name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    public void moveOrStop() {
        if (isMove()) {
            moveCount++;
        }
    }

    private boolean isMove() {
        return RANDOM.nextInt(RANDOM_MAX_NUMBER) >= MOVE_MIN_NUMBER;
    }
}
