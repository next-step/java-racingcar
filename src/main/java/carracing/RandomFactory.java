package carracing;

import java.util.Random;

public class RandomFactory {

    private final Random random = new Random();

    public int generate(int bound) {
        return random.nextInt(bound);
    }
}
