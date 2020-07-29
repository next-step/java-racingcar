package racingcar.domain.util;

import java.util.Random;

public class RandomNumberGenerator {

    public static int getRandomNumberZeroToNine() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
