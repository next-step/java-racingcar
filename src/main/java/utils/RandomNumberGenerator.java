package utils;

import core.Car;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {
    @Override
    public int next() {
        Random random = new Random();
        return random.nextInt(Car.MAX_MOVE_VALUE);
    }
}
