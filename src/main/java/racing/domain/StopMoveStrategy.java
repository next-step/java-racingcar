package racing.domain;

import java.util.Random;

public class StopMoveStrategy implements MoveStrategy{

    @Override
    public boolean movable() {
        return false;
    }
}
