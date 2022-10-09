package racingcar;

import racingcar.strategy.NumberGenerateStrategy;

public class SameNumberGenerateStrategy implements NumberGenerateStrategy {

    @Override
    public int generate() {
        return 5;
    }
}
