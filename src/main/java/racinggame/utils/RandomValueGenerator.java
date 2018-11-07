package racinggame.utils;

import java.util.Random;

public class RandomValueGenerator implements ValueGenerator {
    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
