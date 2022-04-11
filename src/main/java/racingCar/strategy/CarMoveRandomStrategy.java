package racingCar.strategy;

import java.util.Random;

public class CarMoveRandomStrategy implements CarMoveStrategy {

  private final static int RANDOM_BOUND_VALUE = 10;
  private final static int STOP_BOUNDARY_VALUE = 3;

  @Override
  public boolean moveAble() {
    Random random = new Random();
    return STOP_BOUNDARY_VALUE < random.nextInt(RANDOM_BOUND_VALUE);
  }
}
