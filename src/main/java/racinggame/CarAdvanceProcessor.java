package racinggame;

import java.util.Random;

public class CarAdvanceProcessor {

    private static final int RANDOM_LIMIT_NUMBER = 10;
    private static final int ADVANCE_THRESHOLD = 4;

    Random random;

    public CarAdvanceProcessor(Random random) {
        this.random = random;
    }

    public boolean isMovingForward() {
        return random.nextInt(RANDOM_LIMIT_NUMBER) >= ADVANCE_THRESHOLD;
    }

    public void moveForward(int[] carPositions) {
        for( int i = 0; i < carPositions.length; ++i ) {
            carPositions[i] = getNextPosition(carPositions[i]);
        }
    }

    public int getNextPosition(int position) {
        if( isMovingForward() )
            return position+1;

        return position;
    }
}