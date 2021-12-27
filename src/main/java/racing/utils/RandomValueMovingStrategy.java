package racing.utils;

public class RandomValueMovingStrategy implements MovingStrategy {

    private static final int FORWARD_NUMBER = 4;

    @Override
    public boolean isMovable() {
        return generateNumber() >= FORWARD_NUMBER;
    }

    private int generateNumber() {
        return (int) ((Math.random() * 10000) % 10);
    }
}
