package racingcar.repository;

import racingcar.domain.RandomNumber;

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
