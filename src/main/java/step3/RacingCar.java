package step3;

import java.util.Random;

public class RacingCar {
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int ADVANCE_CONDITION = 4;

    private int distance = 0;

    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public boolean isMove(int randomNumber) {
        if (randomNumber > ADVANCE_CONDITION) {
            return true;
        }
        return false;
    }

    public void move() {
        if (isMove(getRandomNumber())) {
            distance++;
        }
    }

    public int getDistance() {
        return distance;
    }


}
