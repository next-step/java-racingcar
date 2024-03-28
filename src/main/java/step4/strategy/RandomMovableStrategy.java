package step4.strategy;

import step4.common.RandomBounded;

public class RandomMovableStrategy implements MovableStrategy {

    @Override
    public boolean isMovable() {
        RandomBounded randomBounded = new RandomBounded();
        return randomBounded.moreThanForwardStandard();
    }

}
