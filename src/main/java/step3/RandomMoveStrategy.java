package step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    private Random randomGenerator = new Random();
    private final int RAND_MAX = 10;
    private final int MOVE_STANDARD = 4;

    @Override
    public int move(int position) {
        if (randomGenerator.nextInt(RAND_MAX) > MOVE_STANDARD) {
            return position + 1;
        }
        return position;
    }
}
