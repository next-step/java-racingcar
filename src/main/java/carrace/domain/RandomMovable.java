package carrace.domain;

import java.util.Random;

public class RandomMovable implements Movable {
    private static final Random RANDOM = new Random();
    @Override
    public boolean isMovable() {
        return RANDOM.nextInt(10) >= 4;
    }
}
