package step5.util;

import java.util.Random;

public class RandomValueGenerator implements MoveStrategy {
    private static final Random RANDOM = new Random();
    
    @Override
    public int getMoveValue() {
        return RANDOM.nextInt(10);
    }
}
