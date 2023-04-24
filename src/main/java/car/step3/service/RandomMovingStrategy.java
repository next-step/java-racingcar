package car.step3.service;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    Random random = new Random();
    private int MAX_BOUNCE = 10;
    private int FORWARD_NUMBER = 4;
    @Override
    public boolean movable() {
        return getRandomNumber() >= FORWARD_NUMBER;
    }

    protected int getRandomNumber() {
        return random.nextInt(MAX_BOUNCE);
    }
}
