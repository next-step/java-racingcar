package step3.strategy;

import step3.common.RandomBounded;

public class RandomMovableStrategy implements MovableStrategy {

    @Override
    public boolean isMovable() {
        RandomBounded randomBounded = new RandomBounded();
        return randomBounded.moreThanForwardStandard();
    }

}
