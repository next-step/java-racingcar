package step3;

import java.util.Random;

public class CarMoveRandomStrategy implements CarMoveStrategy {

    private static final int MAX_MOVE_LIMIT = 10;
    private static final int MOVE_START_AT = 4;
    private static final int STAY_LOCATION = 0;
    private static final int MOVE_STEP = 1;

    Random random = new Random();

    @Override
    public int getMoveCount() {
        int movingCount = random.nextInt(MAX_MOVE_LIMIT);
        return movingCount > MOVE_START_AT ? MOVE_STEP : STAY_LOCATION;
    }

}
