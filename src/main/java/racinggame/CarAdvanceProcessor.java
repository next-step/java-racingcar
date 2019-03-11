package racinggame;

import java.util.Random;

public class CarAdvanceProcessor {

    Random random = new Random();

    void setRandom(Random random) {
        this.random = random;
    }

    Random getRandom() {
        return random;
    }

    public boolean isMovingForward() {
        return random.nextInt(10) >= 4;
    }

    public void moveForward(int[] carPositions) {
        for( int i = 0, length = carPositions.length; i < length; ++i ) {
            carPositions[i] = getNextPosition(carPositions[i]);
        }
    }

    public int getNextPosition(int position) {
        if( !isMovingForward() )
            return position;

        return position+1;
    }
}