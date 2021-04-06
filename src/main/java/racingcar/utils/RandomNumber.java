package racingcar.utils;


import java.util.Random;

public class RandomNumber {

    private static final int RANGE_RANDOM_NUMBERS = 10;
    private static Random random = new Random();

    public static int random() {
        return random.nextInt(RANGE_RANDOM_NUMBERS);
    }

}
