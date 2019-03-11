package racingcar.util;

import java.util.Random;

public class RandomNumberGenerator {

    public int getRandomNumberZeroToNine() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
