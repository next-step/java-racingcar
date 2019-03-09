package racingcar.random;

import java.util.Random;

public class PositiveIntUnder10Generator implements RandomIntGenerator {
    @Override
    public int getRandomInt() {
        return new Random().nextInt(10);
    }
}
