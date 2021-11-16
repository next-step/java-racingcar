package racing.domain.strategy;

import java.util.Random;

public class RandomMoveStrategyImpl implements MoveStrategy {

    private final static Random random = new Random();

    @Override
    public boolean movable() {
        Integer criteriaNumber = 4;
        Integer boundNumber = 10;
        return random.nextInt(boundNumber) > criteriaNumber;
    }
}
