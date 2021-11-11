package step3.strategy;

import java.util.Random;

public class RandomMoveStrategyImpl implements MoveStrategy {

    @Override
    public boolean movable() {
        if (new Random().nextInt(10) > 4) {
            return true;
        }
        return false;
    }
}
