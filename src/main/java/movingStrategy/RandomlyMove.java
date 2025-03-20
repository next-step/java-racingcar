package movingStrategy;

import java.util.Random;

public class RandomlyMove implements Moveable {

    private final Random random;
    private final Integer bound;
    private final Integer threshold;

    public RandomlyMove(Integer bound, Integer threshold) {
        this.random = new Random();
        this.bound = bound;
        this.threshold = threshold;
    }

    @Override
    public Boolean isMoveable() {
         return this.random.nextInt( bound ) >= threshold;
    }
}
