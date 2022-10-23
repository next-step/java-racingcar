package racingcar.race;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        return new Random().nextInt(10);
    }

}