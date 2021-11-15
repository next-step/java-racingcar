package racing.domain.strategy;

import java.util.Random;

public class RandomMoveStrategyImpl implements MoveStrategy {
    @Override
    public boolean movable() {
        Integer criteriaNumber = 4;
        return new Random().nextInt(10) > criteriaNumber;
    }
}
