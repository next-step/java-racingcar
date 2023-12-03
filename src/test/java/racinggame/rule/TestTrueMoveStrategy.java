package racinggame.rule;

import racinggame.domain.rule.MoveStrategy;

public class TestTrueMoveStrategy implements MoveStrategy {
    @Override
    public boolean move() {
        return true;
    }
}
