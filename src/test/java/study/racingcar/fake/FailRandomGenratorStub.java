package study.racingcar.fake;

import java.util.Random;
import study.racingcar.RandomGenerator;

public class FailRandomGenratorStub extends RandomGenerator {
    public FailRandomGenratorStub(Random random) {
        super(random);
    }

    @Override
    public int number() {
        return 3;
    }
}
