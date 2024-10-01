package racingcar.util;

import racingcar.model.wrapper.ForwardStatus;

import java.util.Random;

public class RandomNumberGenerator implements NumberCreator {

    public static final Random RANDOM = new Random();
    public static final int RANDOM_NUMBER_BOUND = 10;

    @Override
    public ForwardStatus number() {
        return new ForwardStatus(RANDOM.nextInt(RANDOM_NUMBER_BOUND));
    }
}
