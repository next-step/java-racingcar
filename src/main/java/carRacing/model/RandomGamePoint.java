package carRacing.model;

import java.util.Random;

public class RandomGamePoint implements GamePoint {

    private static int RADOM_LIMIT_BOUNDARY = 10;
    private Random random;

    public RandomGamePoint() {
        this.random = new Random();
    }

    @Override
    public int getGamePoint() {
        return this.random.nextInt(RADOM_LIMIT_BOUNDARY);
    }
}
