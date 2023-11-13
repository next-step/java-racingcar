package racing.domain;

import java.util.Random;

public class ForwardMoveStrategy implements MoveStrategy{

    @Override
    public boolean movable() {
        return true;
    }
}
