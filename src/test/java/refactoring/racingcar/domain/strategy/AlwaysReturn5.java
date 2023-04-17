package refactoring.racingcar.domain.strategy;

import refactoring.racingcar.strategy.RandomStrategy;

public class AlwaysReturn5 implements RandomStrategy {
    @Override
    public int getOne() {
        return 5;
    }
}
