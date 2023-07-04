package racingcar;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
