package step3;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

    @Override
    public boolean move() {
        if (getRandomValue() > 3) {
            return true;
        }
        return false;
    }

    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
