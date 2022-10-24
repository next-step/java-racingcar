package racingcar.race;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    private Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(10);
    }

}