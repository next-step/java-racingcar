package car.randomNumer.impl;

import car.randomNumer.RandomNumber;

public class FixedNumberByParameter implements RandomNumber {

    private final int FIX_NUMBER;

    public FixedNumberByParameter(int fixNumber) {
        this.FIX_NUMBER = fixNumber;
    }

    @Override
    public int getRandomNumber() {
        return FIX_NUMBER;
    }
}
