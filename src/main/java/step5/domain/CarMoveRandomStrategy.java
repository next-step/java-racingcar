package step5.domain;

import java.util.Random;

/*
 * Java Racing Game
 * CarMoveRandomStrategy
 * ver. 1.0
 * 2020.05.27
 * Copyright ...
 */
public class CarMoveRandomStrategy implements CarMoveStrategy {

    private static final int MAX_MOVE_LIMIT = 10;
    private static final int MOVE_START_AT = 4;
    private static final int STAY_LOCATION = 0;
    private static final int MOVE_STEP = 1;

    private static final Random random = new Random();

    @Override
    public int getMoveCount() {
        int movingCount = random.nextInt(MAX_MOVE_LIMIT);
        return (movingCount > MOVE_START_AT) ? MOVE_STEP : STAY_LOCATION;
    }


}
