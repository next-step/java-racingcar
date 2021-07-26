package study.racing.common;

import java.util.Random;

public class Common {

    private static final Random random = new Random();

    private static final int RANDOM_MAX_NUMBER = 10;

    public static int toInt(String value) {
        return Integer.parseInt(value);
    }

    public static int createRandomNumber(){
        return random.nextInt(RANDOM_MAX_NUMBER);
    }

}