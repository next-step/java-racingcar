package study.racingcar;

import java.util.Random;

public class SuccessRandomGenratorStub extends RandomGenerator {
    public SuccessRandomGenratorStub(Random random) {
        super(random);
    }

    @Override
    public int number() {
        return 4;
    }
}
