package racing.domain;

import java.util.Random;

public class RandomStrategy implements MoveStrategy{

    private static final int FORWARDING_CONDITION = 4;

    @Override
    public boolean isMovable() {
        return new Random().nextInt(10) > FORWARDING_CONDITION;
    }
}
