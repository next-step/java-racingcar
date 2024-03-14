package racingcar;

public class RandomMoveCondition implements MoveCondition {

    private static final int BOUND = 10;
    private static final int MOVE_CONDITION = 4;

    @Override
    public boolean isMovable() {
      return (int) (Math.random() * BOUND) >= MOVE_CONDITION;
    }
}
