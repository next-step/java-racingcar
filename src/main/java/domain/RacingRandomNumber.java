package domain;

import java.util.Random;

public class RacingRandomNumber {

    private Integer number;

    public RacingRandomNumber(Integer number) {
        this.number = number;
    }

    public RacingRandomNumber(Random random) {
        this.number = random.nextInt(10);
    }

    public Integer number() {
        return number;
    }
}
