package racing.infra;

import racing.domain.Moveable;

import java.util.Random;

public class NextStepMoveable implements Moveable {

    private static final int RANGE = 10;

    private static final int MOVE_STANDARD = 4;

    private static final Random random = new Random();

    @Override
    public boolean isMove() {
        return random.nextInt(RANGE) >= MOVE_STANDARD;
    }
}
