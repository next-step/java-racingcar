package com.hskim.nextstep.step03.model;

import com.hskim.nextstep.step03.utils.RandomUtils;

public class RandomMovableStrategy implements MovableStrategy {

    private int randomBound;
    private int lowerBound;

    public RandomMovableStrategy(int randomBound, int lowerBound) {

        this.randomBound = randomBound;
        this.lowerBound = lowerBound;
    }

    @Override
    public boolean isMovable() {

        return RandomUtils.getRandomInteger(randomBound) >= lowerBound;
    }
}
