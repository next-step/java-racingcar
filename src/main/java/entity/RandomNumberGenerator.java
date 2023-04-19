package entity;

import entity.NumberGenerator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final Random RANDOM = new Random();

    @Override
    public int generate() {
        return RANDOM.nextInt(RANDOM_NUMBER_BOUND);
    }
}
