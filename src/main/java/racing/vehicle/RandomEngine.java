package racing.vehicle;

import java.util.Random;

public class RandomEngine implements Engine {
    private final Random random;
    private static final int RANDOM_BOUND = 10;
    private static final int THRESHOLD = 4;
    private static final int DISPLACEMENT = 1;
    private static final int HOLD = 0;

    public RandomEngine() {
        this.random = new Random();
    }

    public RandomEngine(Random random) {
        this.random = random;
    }

    @Override
    public int accelerate() {
        if (random.nextInt(RANDOM_BOUND) >= THRESHOLD) {
            return DISPLACEMENT;
        }
        return HOLD;
    }
}
