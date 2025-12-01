package domain;

import util.RandomNumberGenerator;

public class RandomNumber {
    private int randomNumber;

    public RandomNumber() {
        this.randomNumber = RandomNumberGenerator.random();
    }

    public boolean isBiggerThan(int number) {
        return randomNumber > number;
    }
}
