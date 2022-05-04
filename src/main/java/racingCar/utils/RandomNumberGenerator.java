package racingCar.utils;

import racingCar.domains.NumberGeneratorStrategy;

import java.util.Random;

public class RandomNumberGenerator implements NumberGeneratorStrategy {
    static Random random = new Random();
    static final int BOUNDS = 10;

    public int generate() {
        return random.nextInt(this.BOUNDS);
    }
}
