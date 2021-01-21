package racingcar;

public class LookLikeRandomMovementCondition extends MovementCondition {
    private final boolean[] order = {true, false, false};
    private int cnt;

    public LookLikeRandomMovementCondition() {
        cnt = 0;
    }

    @Override
    public boolean satisfies() {
        return order[cnt++ % 3];
    }
}
