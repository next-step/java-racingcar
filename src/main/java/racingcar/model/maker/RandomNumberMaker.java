package racingcar.model.maker;

import java.util.Random;

public class RandomNumberMaker implements NumberMaker {
    private static final int RANDOM_NUMBER_BOUND = 10;

    public int make() {
        Random random = new Random();

        return random.nextInt(RANDOM_NUMBER_BOUND);
    }
}
