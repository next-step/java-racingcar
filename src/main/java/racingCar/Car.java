package racingCar;

import java.util.Random;

public class Car {
    static Random random = new Random();
    static final int BOUND = 10;
    int distance = 0;

    public void tryMove() {
        if (canMoveForward(getRandomValue())) {
            distance++;
        }
    }

    public int getRandomValue() {
        return random.nextInt(BOUND);
    }

    public boolean canMoveForward(int number) {
        return number >= 4;
    }

    public int getDistance() {
        return distance;
    }
}
