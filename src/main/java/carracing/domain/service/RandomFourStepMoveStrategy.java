package carracing.domain.service;

import carracing.domain.utils.RandomUtils;

import java.util.function.BooleanSupplier;

public class RandomFourStepMoveStrategy implements MoveStrategy{

  private static final int STEP_FORWARD_STANDARD = 4;

  @Override
  public BooleanSupplier isMovable() {
    return () -> RandomUtils.isGreaterThanOrEquals(STEP_FORWARD_STANDARD);
  }
}
