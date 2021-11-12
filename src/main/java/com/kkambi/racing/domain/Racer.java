package com.kkambi.racing.domain;

import com.kkambi.racing.util.Dice;

public class Racer {

    private final Car myCar;

    public Racer(Car myCar) {
        this.myCar = myCar;
    }

    public void attemptToMove() {
        if (Dice.roll(Bound.ROLL) >= Bound.MIN_MOVE.getValue()) {
            myCar.move();
        }
    }

    public String  getLocation() {
        return myCar.getLocation();
    }
}
