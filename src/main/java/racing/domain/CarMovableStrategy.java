package racing.domain;

import java.util.Random;

public class CarMovableStrategy implements MovableStrategy {

    @Override
    public int randomMovable() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
