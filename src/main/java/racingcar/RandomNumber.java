package racingcar;

import java.util.Random;

public class RandomNumber {

    public static final int MAXIMUM_NUMBER = 10;
    private static Random random = new Random();

    public static int random() {
        return random.nextInt(MAXIMUM_NUMBER);
    }

}
