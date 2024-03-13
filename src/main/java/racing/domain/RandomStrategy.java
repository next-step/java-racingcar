package racing.domain;

import java.util.Random;

public class RandomStrategy implements MoveStrategy {

    private static final Random random = new Random();
    private static final int FORWARDING_CONDITION = 4;
    private static final int MAX_NUMBER = 10;


    @Override
    public boolean isMovable() {
        return random.nextInt(MAX_NUMBER) > FORWARDING_CONDITION;
    }
}
