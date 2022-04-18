package racingcar.domain;

import java.util.Random;

public class RandomStrategy implements RacingStrategy{

    private static final int MAXVALUE = 10;
    private static final Random random = new Random();

    @Override
    public int createNumber() {
        return random.nextInt(MAXVALUE);
    }

}
