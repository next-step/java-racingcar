package study.racinggame.domain.car;

import java.util.Random;

public class Engine {
    private static final int THRESHOLD = 4;
    private static final int BOUND = 10;

    private final int value;

    public Engine() {
        Random random = new Random();
        this.value = random.nextInt(BOUND);
    }

    public Engine(int value) {
        this.value = value;
    }

    public boolean canWork() {
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
