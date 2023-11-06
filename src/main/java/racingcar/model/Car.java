package racingcar.model;

import java.util.Random;

public class Car {
    private static final int RANDOM_VALUE_RANGE = 10;
    private static final int ADVANCE_MINIMUM_VALUE = 4;
    private int position;

    private final Random random = new Random();

    public Car() {
        this.position = 0;
    }

    public int randomValue() {
        return random.nextInt(RANDOM_VALUE_RANGE);
    }

    public boolean canMove(int number) {
        return number >= ADVANCE_MINIMUM_VALUE;
    }

    public void forwardOneStep(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public void carTurn() {
        int randomNumber = randomValue();
        boolean canMove = canMove(randomNumber);
        forwardOneStep(canMove);
    }

    public int getPosition() {
        return position;
    }

}
