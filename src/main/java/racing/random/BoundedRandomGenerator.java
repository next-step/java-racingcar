package racing.random;

import java.util.Random;

public class BoundedRandomGenerator implements RandomGenerator {

    private Random random;

    private int bound;

    public BoundedRandomGenerator(int bound) {
        random = new Random();
        this.bound = bound;
    }

    @Override
    public int nextInt() {
        return random.nextInt(bound);
    }
}
