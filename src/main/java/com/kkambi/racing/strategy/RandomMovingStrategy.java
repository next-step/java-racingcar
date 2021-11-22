package com.kkambi.racing.strategy;

import com.kkambi.racing.util.Dice;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int criteriaToMove = 4;

    @Override
    public boolean movable() {
        return Dice.roll(10) >= criteriaToMove;
    }
}
