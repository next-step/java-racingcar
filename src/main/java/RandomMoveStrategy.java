import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {
    private static final Random random = new Random();

    @Override
    public boolean move() {
        return random.nextInt(10) >= 4;
    }
}
