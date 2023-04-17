package racingcar.strategy;

import racingcar.domain.RandomNumber;

import java.util.function.Predicate;

public class NormalMoveStrategy implements MoveStrategy {
  private static final int CAR_MOVEMENT_STANDARD = 4;   // random 값이 4이상인 경우 전진

  @Override
  public boolean decideMoveOrHold() {
    RandomNumber randomNumber = new RandomNumber();
    Predicate<Integer> predicate = (number) -> number >= CAR_MOVEMENT_STANDARD;

    return predicate.test(randomNumber.calculateRandomNumber());
  }
}
