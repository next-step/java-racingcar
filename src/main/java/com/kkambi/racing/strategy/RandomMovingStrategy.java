package com.kkambi.racing.strategy;

import com.kkambi.racing.domain.Location;
import com.kkambi.racing.util.Dice;

public class RandomMovingStrategy implements MovingStrategy {

    private static final int criteriaToMove = 4;

    @Override
    public Location move(Location location) {
        int randomValue = Dice.roll(10);
        if (randomValue >= criteriaToMove) {
            return location.move();
        }
        return location;
    }
}
