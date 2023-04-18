package step5.domain.stretagy;

import java.util.Random;

public class SimpleRandomMovingStrategy implements MovingStrategy {

    private final int threshold;
    private final int randomRange;

    public SimpleRandomMovingStrategy() {
        this.threshold = 4;
        this.randomRange = 10;
    }

    public SimpleRandomMovingStrategy(int threshold, int randomRange) {
        this.threshold = threshold;
        this.randomRange = randomRange;
    }

    @Override
    public boolean goOrStop() {
        return threshold <= new Random().nextInt(randomRange);
    }

}
