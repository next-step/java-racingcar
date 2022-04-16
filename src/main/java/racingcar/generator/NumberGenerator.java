package racingcar.generator;

import java.util.Random;

public class NumberGenerator implements Generator<Integer, Integer>{

    private static final Random random = new Random();

    @Override
    public Integer generate(Integer value) {
        return random.nextInt(value);
    }
}
