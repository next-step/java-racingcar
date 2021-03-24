package ch01.racinggame.domain;

import java.util.Random;

public class RandomNumber {
    private static final int limitMovableNumber = 4;

    public boolean movable(int number) {
        return number > limitMovableNumber;
    }


    public int randomNumber() {
        return new Random().nextInt(10);
    }
}
