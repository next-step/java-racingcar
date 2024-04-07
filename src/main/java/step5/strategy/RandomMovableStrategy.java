package step5.strategy;

import step5.common.RandomBounded;

public class RandomMovableStrategy implements MovableStrategy {

    @Override
    public boolean isMovable() {
        RandomBounded randomBounded = new RandomBounded();
        return randomBounded.moreThanForwardStandard();
    }

}
