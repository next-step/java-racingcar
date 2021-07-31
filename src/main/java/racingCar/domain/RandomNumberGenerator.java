package racingCar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    static private final int THRESHOLD = 10;
    static Random random = new Random();

    @Override
    public int getNumber() {
        return random.nextInt(THRESHOLD);
    }

}
