import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int RANDOM_NUMBER_RANGE = 10;
    private static final int MOVE_THRESHOLD = 4;
    private final Random random = new Random();

    @Override
    public boolean shouldMove() {
        return random.nextInt(RANDOM_NUMBER_RANGE) >= MOVE_THRESHOLD;
    }
}
