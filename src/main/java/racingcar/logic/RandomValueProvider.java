package racingcar.logic;

import java.util.Random;

public class RandomValueProvider {

    private final Random random = new Random();
    private Integer range;

    public RandomValueProvider(Integer range) {
        this.range = range;
    }

    public Integer get() {
        return random.nextInt(range);
    }
}
