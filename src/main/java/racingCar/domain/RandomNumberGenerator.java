package racingCar.domain;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
}
