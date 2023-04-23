package car.step3.service;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    private int MAX_BOUNCE = 10;
    private int FORWARD_NUMBER = 4;
    @Override
    public boolean movable() {
        return getRandomNumber() >= FORWARD_NUMBER;
    }

    protected int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_BOUNCE);
    }
}
