package racing.refactor.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{

    private final static int FORWARD_CONDITION = 4;
    private final static int RANDOM_MAX = 10;

    @Override
    public boolean movable() {
        return FORWARD_CONDITION <= getRandomNumber();
    }

    private int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANDOM_MAX);
    }
}
