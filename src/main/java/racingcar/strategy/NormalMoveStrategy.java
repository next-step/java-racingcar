package racingcar.strategy;

import racingcar.domain.RandomNumber;
import static racingcar.strategy.ConstantMoveFactors.DEFAULT_CAR_MOVEMENT_STANDARD;
import static racingcar.strategy.ConstantMoveFactors.DEFAULT_MOVEMENT_DISTANCE;

public class NormalMoveStrategy implements MoveStrategy {

  @Override
  public boolean decideMoveOrHold() {
    RandomNumber randomNumber = new RandomNumber();
    return randomNumber.calculateRandomNumber() >= DEFAULT_CAR_MOVEMENT_STANDARD;
  }

  @Override
  public int moveForward() {
    return DEFAULT_MOVEMENT_DISTANCE;
  }
}
