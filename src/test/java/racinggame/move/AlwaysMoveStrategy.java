package racinggame.move;

import racinggame.model.move.MoveStrategy;

public class AlwaysMoveStrategy implements MoveStrategy {

    @Override
    public boolean moveable() {
        return true;
    }
}
