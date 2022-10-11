package racing;

public class RandomNumMovingStrategy implements MovingStrategy {
    private static final int AVAILABLE_RUN_THRESHOLD = 4;
    private static final int MAX_BOUND = 10;

    @Override
    public boolean movable() {
        return generateRandom() >= AVAILABLE_RUN_THRESHOLD;
    }

    private static int generateRandom() {
        return (int)(Math.random() * MAX_BOUND) + 1;
    }
}
