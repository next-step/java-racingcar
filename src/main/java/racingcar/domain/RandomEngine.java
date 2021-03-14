package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomEngine implements Engine{
    @Override
    public int getPower() {
        return RandomGenerator.getRandomValue();
    }
}
