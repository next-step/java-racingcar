package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{

    static final int MOVE_CHECK_NUMBER = 4;
    private Random random = new Random();
    @Override
    public boolean movable() {
        return random.nextInt(10) >= MOVE_CHECK_NUMBER;
    }
}
