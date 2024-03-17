package step3.application.generator;

import java.util.Random;

public class MovableRandomGenerator implements MovableGenerator {

    private final Random random;
    public static final int MAX_BOUND = 10;
    public static final int MOVE_THRESHOLD = 4;

    public MovableRandomGenerator() {
        this.random = new Random();
    }

    public boolean drawMovable() {
        return random.nextInt(MAX_BOUND) >= MOVE_THRESHOLD;
    }
}