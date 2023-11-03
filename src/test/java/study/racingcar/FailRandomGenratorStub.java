package study.racingcar;

import java.util.Random;

public class FailRandomGenratorStub extends RandomGenerator {
    public FailRandomGenratorStub(Random random) {
        super(random);
    }

    @Override
    public int number() {
        return 3;
    }
}
