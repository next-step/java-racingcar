package racingcar.common;

import java.util.Random;

public class RandomHelper {

    public static int getRandomNumber(int num) {
        Random random = new Random();
        return random.nextInt(num);
    }
}
