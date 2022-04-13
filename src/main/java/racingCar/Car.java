package racingCar;

import java.util.Random;

public class Car {
    static Random random = new Random();
    static final int BOUND = 10;

    public int getRandomValue() {
        return random.nextInt(BOUND);
    }

    public boolean canMoveForward(int number) {
        return number >= 4;
    }
}
