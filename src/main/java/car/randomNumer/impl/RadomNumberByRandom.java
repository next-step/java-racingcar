package car.randomNumer.impl;

import car.randomNumer.RandomNumber;

import java.util.Random;

public class RadomNumberByRandom implements RandomNumber {

    private final int BOUND_NUMBER;

    public RadomNumberByRandom(int boundNumber) {
        this.BOUND_NUMBER = boundNumber;
    }

    @Override
    public int getRandomNumber() {
        return new Random().nextInt(BOUND_NUMBER);
    }
}
