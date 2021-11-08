package edu.nextstep.camp;

public class TestMovePolicy {
    public static MovePolicy ALWAYS_MOVE_POLICY = () -> true;
    public static MovePolicy NEVER_MOVE_POLICY = () -> false;
}
