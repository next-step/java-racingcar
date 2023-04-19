package refactoring.racingcar.domain.strategy;

import refactoring.racingcar.strategy.MoveStrategy;

public class AlwaysStopStrategy implements MoveStrategy {
    @Override
    public boolean shouldMove() {
        return false;
    }
}
