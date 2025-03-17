package racing.rule;

public class RacingGameMoveRule extends MoveRule {
    @Override
    public boolean isMovable(int value) {
        return value >= MIN_MOVE_VALUE;
    }
}
