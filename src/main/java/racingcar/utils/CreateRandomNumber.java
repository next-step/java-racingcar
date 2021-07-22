package racingcar.utils;

import java.util.Random;

public class CreateRandomNumber {
    private static final int MAX = 10;
    private static Random random = new Random();

    public static int getRandomNumber(){
        return random.nextInt(MAX);
    }
}
