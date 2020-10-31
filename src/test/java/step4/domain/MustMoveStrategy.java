package step4.domain;

import step3.domain.MoveStrategy;

public class MustMoveStrategy implements MoveStrategy {
    @Override
    public boolean move() {
        return true;
    }
}
