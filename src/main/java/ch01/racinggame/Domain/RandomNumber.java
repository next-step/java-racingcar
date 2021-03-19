package ch01.racinggame.Domain;

import java.util.Random;

public class RandomNumber {
    static final int limitMovableNumber = 4;
    private int number = 0;

    RandomNumber(){

    }

    public boolean movable(int number){
        return number > limitMovableNumber;
    }

    private int randomNumber() {
        return new Random().nextInt(10);
    }
}
