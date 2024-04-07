package step5.strategy;

import step5.common.RandomBounded;

import java.util.Random;

public class RandomMovableStrategy implements MovableStrategy {

    RandomBounded randomBounded;

    public RandomMovableStrategy() {
        this.randomBounded = new RandomBounded();
    }

    public RandomMovableStrategy(RandomBounded randomBounded) {
        this.randomBounded = randomBounded;
    }

    @Override
    public boolean isMovable() {
        return this.randomBounded.moreThanForwardStandard();
    }

}
