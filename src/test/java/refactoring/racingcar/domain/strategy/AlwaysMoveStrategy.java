package refactoring.racingcar.domain.strategy;

import refactoring.racingcar.strategy.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {
    @Override
    public boolean shouldMove() {
        return true;
    }
}
