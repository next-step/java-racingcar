package racingcar;

public class TestMoveCondition implements MoveCondition {

    private boolean isMovable;

    public TestMoveCondition(boolean isMovable) {
      this.isMovable = isMovable;
    }

    @Override
    public boolean isMovable() {
      return isMovable;
    }
}
