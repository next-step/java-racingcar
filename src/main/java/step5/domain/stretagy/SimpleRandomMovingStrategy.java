package step5.domain.stretagy;

import java.util.Random;

public class SimpleRandomMovingStrategy implements MovingStrategy {

    private final int threshold;
    private final int randomRange;
    private final Random random = new Random();

    public SimpleRandomMovingStrategy() {
        this(4, 10);
    }

    public SimpleRandomMovingStrategy(int threshold, int randomRange) {
        this.threshold = threshold;
        this.randomRange = randomRange;
    }

    @Override
    public boolean isMoved() {
        return threshold <= random.nextInt(randomRange);
    }

}
