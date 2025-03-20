import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;
    private final Random random = new Random();

    @Override
    public boolean shouldMove() {
        return random.nextInt(10) >= MOVE_THRESHOLD;
    }
} 