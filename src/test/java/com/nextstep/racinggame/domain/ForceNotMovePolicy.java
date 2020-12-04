package com.nextstep.racinggame.domain;

public class ForceNotMovePolicy implements MovePolicy {
    @Override
    public boolean canMove() {
        return false;
    }
}
