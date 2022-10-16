package step5.domain;

import step5.domain.MovableStrategy;

public class StopStrategy implements MovableStrategy {

    @Override
    public boolean isMovable() {
        return false;
    }
}
