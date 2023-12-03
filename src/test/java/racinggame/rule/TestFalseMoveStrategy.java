package racinggame.rule;

import racinggame.domain.rule.MoveStrategy;

public class TestFalseMoveStrategy implements MoveStrategy {
    @Override
    public boolean move() {
        return false;
    }
}
