package racingcar.common;

import java.util.Random;

public class RandomHelper {
    static Random random = new Random();

    public static int getRandomNumber(int num) {
        return random.nextInt(num);
    }
}
