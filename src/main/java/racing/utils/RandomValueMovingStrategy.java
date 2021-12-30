package racing.utils;

public class RandomValueMovingStrategy implements MovingStrategy {

    private static final int FORWARD_NUMBER = 4;
    private static final int MAX_NUMBER = 10;
    private static final int MIN_NUMBER = 1;

    @Override
    public boolean isMovable() {
        return generateNumber() >= FORWARD_NUMBER;
    }

    private int generateNumber() {
        return ((int) (Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER);
    }
}
