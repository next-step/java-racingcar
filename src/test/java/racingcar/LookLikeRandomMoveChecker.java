package racingcar;

public class LookLikeRandomMoveChecker extends MoveChecker {
    private final boolean[] order = {true, false, false};
    private int cnt;

    public LookLikeRandomMoveChecker() {
        cnt = 0;
    }

    @Override
    public boolean isMoving() {
        return order[cnt++ % 3];
    }
}
