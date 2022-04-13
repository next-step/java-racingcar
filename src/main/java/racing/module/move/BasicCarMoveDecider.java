package racing.module.move;

import java.util.Random;

public class BasicCarMoveDecider implements CarMoveDecider{

    private static final Random random = new Random();

    @Override
    public boolean isMovingForwardCondition() {
        return random.nextInt(10) >= 4;
    }
}
