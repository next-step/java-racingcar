package step5;

import java.util.Random;

public class CarMovingStrategy implements MovingStrategy {
    static final int BOUND = 10;

    @Override
    public boolean movable() {
        return getRandomNumber() >= 4;
    }

    private int getRandomNumber() {
        return new Random().nextInt(BOUND);
    }
}
