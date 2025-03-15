package car_racing.domain.strategy;

import java.util.Random;

public class RandomMovingStrategy implements CarMovingStrategy{
    private static final Random random = new Random();
    private static final int MOVE_THRESHOLD = 4;


    @Override
    public boolean movable() {
        return random.nextInt() > MOVE_THRESHOLD;
    }
}
