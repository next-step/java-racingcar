package step4.domain;

import step3.domain.MoveStrategy;

public class NotMoveStrategy implements MoveStrategy {

    @Override
    public boolean move() {
        return false;
    }
}
