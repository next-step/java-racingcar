package RacingCar.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final Random random = new Random();

    public boolean moveable() {
        if(random.nextInt(RANDOM_NUMBER_RANGE) > 3){
            return true;
        }
        return false;
    }
}
