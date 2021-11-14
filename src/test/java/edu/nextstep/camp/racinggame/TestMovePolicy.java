package edu.nextstep.camp.racinggame;

import edu.nextstep.camp.racinggame.domain.car.policy.MovePolicy;

public class TestMovePolicy {
    public static MovePolicy ALWAYS_MOVE_POLICY = () -> true;
    public static MovePolicy NEVER_MOVE_POLICY = () -> false;
}
