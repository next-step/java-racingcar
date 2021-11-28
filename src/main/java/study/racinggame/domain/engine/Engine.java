package study.racinggame.domain.engine;

import java.util.Random;

public class Engine implements MovingStrategy {
    private static final int THRESHOLD = 4;
    private static final int BOUND = 10;

    private final int value;

    public Engine() {
        Random random = new Random();
        this.value = random.nextInt(BOUND);
    }

    public Engine(final int value) {
        this.value = value;
    }

    @Override
    public boolean movable() {
        return this.value >= THRESHOLD;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "RandomNumber{" +
                "value=" + value +
                '}';
    }
}
