package car.randomNumer.impl;

import car.randomNumer.RandomNumber;

public class RandomNumberByParameter implements RandomNumber {

    private final int FIX_NUMBER;

    public RandomNumberByParameter(int fixNumber) {
        this.FIX_NUMBER = fixNumber;
    }

    @Override
    public int getRandomNumber() {
        return FIX_NUMBER;
    }
}
