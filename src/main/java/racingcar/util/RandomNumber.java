package racingcar.util;

import java.util.Random;

public class RandomNumber {
    private static final int BOUND_NUMBER = 10;
    private static Random random = new Random();

    public static int randomNumberExtraction(){
        return random.nextInt(BOUND_NUMBER);
    }
}
