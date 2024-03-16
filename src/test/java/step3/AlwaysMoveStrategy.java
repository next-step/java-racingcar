package step3;

import step3.domain.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean move() {
        return true;
    }
}
