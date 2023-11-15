package study.racingcar.fake;

import java.util.Random;
import study.racingcar.util.RandomGenerator;

public class SuccessRandomGenratorStub extends RandomGenerator {
    public SuccessRandomGenratorStub(Random random) {
        super(random);
    }

    @Override
    public int number() {
        return 4;
    }
}
