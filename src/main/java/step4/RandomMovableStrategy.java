package step4;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy{

    private Random random = new Random();

    @Override
    public Boolean isMovable() {
        if (random.nextInt() >= 4) {
            return true;
        }
        return false;
    }
}
