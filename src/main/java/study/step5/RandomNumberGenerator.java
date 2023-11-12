package study.step5;

import java.util.Random;

import study.step5.domain.NumberGenerator;

public class RandomNumberGenerator implements NumberGenerator {

    public static final int BOUND = 10;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(BOUND);
    }
}
