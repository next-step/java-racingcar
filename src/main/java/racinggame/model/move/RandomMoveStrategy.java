package racinggame.model.move;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy{
    private static final int RANDOM_MAX_NUM = 9;
    private static final int STANDARD_TO_ADVANCE = 4;
    private static final Random random = new Random();

    @Override
    public boolean moveable() {
        int radomValue = random.nextInt(RANDOM_MAX_NUM);

        return radomValue >= STANDARD_TO_ADVANCE;
    }
}
