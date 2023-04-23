package study.racingcar.domain;

import study.racingcar.factory.RandomIntFactory;

public class RandomInt {

  private final int number;

  public RandomInt(final int number) {
    if (RandomIntFactory.DEFAULT_START_BOUND > number
        || RandomIntFactory.DEAFULT_END_BOUND - 1 < number) {
      throw new IllegalArgumentException("유효한 값이 아닙니다.");
    }
    this.number = number;
  }

  public boolean isGreaterThan(int minimumMoveValue) {
    return this.number >= minimumMoveValue;
  }
}
