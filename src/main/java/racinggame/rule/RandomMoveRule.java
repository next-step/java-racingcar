package racinggame.rule;

import java.util.function.IntSupplier;

public class RandomMoveRule implements MoveRule {

  private final int SHAKE_BOUND = 10;
  private final int MIN_MOVE_CONDITION = 4;

  private IntSupplier randomSupplier;

  public RandomMoveRule() {
    this.randomSupplier = () -> new ShakeRandom(SHAKE_BOUND).shakeShake();
  }

  @Override
  public boolean isAbleToMove() {
    return rolling() >= MIN_MOVE_CONDITION;
  }

  private int rolling() {
    return randomSupplier.getAsInt();
  }
}
