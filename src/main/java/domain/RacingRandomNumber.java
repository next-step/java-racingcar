package domain;

import java.util.Random;

public class RacingRandomNumber {

    public static final int MAX_BOUND = 10;
    private Integer number;

    public RacingRandomNumber(Integer number) {
        this.number = number;
    }

    public RacingRandomNumber(Random random) {
        this.number = random.nextInt(MAX_BOUND);
    }

    public Integer number() {
        if (number >= 10)
            throw new IllegalArgumentException();
        return number;
    }
}
