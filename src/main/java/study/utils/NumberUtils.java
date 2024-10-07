package study.utils;

import java.util.Random;

public class NumberUtils {

    public static int randomNumberUnder10() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
