package racingcar.util;

import racingcar.model.wrapper.ForwardStatus;

import java.util.Random;

public class RandomNumberGenerator implements NumberCreator {

    @Override
    public ForwardStatus number() {
        return new ForwardStatus(new Random().nextInt(10));
    }
}
