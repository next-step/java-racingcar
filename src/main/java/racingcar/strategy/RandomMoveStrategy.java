package racingcar.strategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

  private static final Random RANDOM = new Random();
  private static final int MAXIMUM_BOUNDARY_NUMBER = 10;
  private static final int FORWARD_BOUNDARY_NUMBER = 4;


  @Override
  public boolean isMovable() {
    return RANDOM.nextInt(MAXIMUM_BOUNDARY_NUMBER) >= FORWARD_BOUNDARY_NUMBER;
  }
}
