package racingcar;

import java.util.Random;

public class RandomNumber {
    static Random random = new Random();

    private RandomNumber() {
    }

    public static int getNumber() {
        return random.nextInt(10);
    }
}
