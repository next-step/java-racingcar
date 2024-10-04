package step3;

import java.util.Random;

public class Car {

    private static final int MIN_MOVE_CONDITION_NUMBER = 4;
    private static final int RANDOM_NUMBER_BOUND = 10;
    private int distance;

    public void move() {
        if (isValidCondition(getRandomNumber())) {
            distance++;
        }
    }

    public int showDistance() {
        return distance;
    }

    public boolean isValidCondition(int randomNumber) {
        return randomNumber >= MIN_MOVE_CONDITION_NUMBER;
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
