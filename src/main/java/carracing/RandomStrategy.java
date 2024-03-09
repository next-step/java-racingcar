package carracing;

import java.util.Random;

public class RandomStrategy implements MovingStrategy {
    private static final Random random = new Random();

    @Override
    public int move() {
        return random.nextInt(10)  >= 4 ? 1 : 0;
    }
}
