import java.util.Random;

public class RandomMove implements MovePolicy{
    private static final int rangeRandom = 10;
    private static final int cutMove = 4;
    private static final Random random = new Random();

    @Override
    public boolean isAbleToMove() {
        return random.nextInt(rangeRandom) >= cutMove;
    }
}
