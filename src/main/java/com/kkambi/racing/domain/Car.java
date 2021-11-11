package com.kkambi.racing.domain;

import com.kkambi.racing.util.Dice;

public class Car {

    private static final String LOCATION_UNIT = "-";

    private final StringBuilder location = new StringBuilder();

    public void attemptToMove() {
        if (Dice.roll(Bound.ROLL) >= Bound.MIN_MOVE.getValue()) {
            location.append(LOCATION_UNIT);
        }
    }
}
