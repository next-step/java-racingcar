package test;

import java.util.Random;

public class RandomValueMovingStrategy implements MovingStrategy{
    @Override
    public boolean movable() {
        return getRandomNo() >= 4;
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
