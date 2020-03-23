package CarRacing;

public class MovingStrategy implements RacingStrategy {
    static final int WINNING_POINT = 4;

    @Override
    public boolean movable() {
        return RandomUtils.generateRandom() >= WINNING_POINT;
    }
}
