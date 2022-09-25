package racingcar.utils;

import java.util.Random;

public class RandomNumber {

    private static final Random random = new Random();
    private static final int MAX_NUM = 10;
    public static int generate(){
        return random.nextInt(MAX_NUM);
    }
}
