package racingcar;

import java.util.Random;

public class RacingCar {
    public static int getRandomValue() {
        return new Random().nextInt(10);
    }

    public static int moveForward(int randomValue) {
        if (randomValue >= 4) {
            return 1;
        }
        return 0;
    }
}
