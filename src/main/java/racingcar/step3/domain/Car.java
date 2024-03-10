package racingcar.step3.domain;

import racingcar.step3.util.RandomNumberUtil;

import java.util.UUID;

public class Car {

  private final UUID id = UUID.randomUUID();
  private final String carName;
  private int moveCount;

  private static final int DEFAULT_MOVE_COUNT = 0;
  private static final int RANDOM_NUMBER_BOUND = 10;
  private static final int MEET_CONDITION_FOR_MOVEMENT = 4;

  public Car(String carName) {
    this.carName = carName;
    this.moveCount = DEFAULT_MOVE_COUNT;
  }

  public String getCarName() {
    return carName;
  }

  public int getMoveCount() {
    return moveCount;
  }

  public void move() {
    if (isSatisfied()) {
      this.moveCount += 1;
    }
  }

  private boolean isSatisfied() {
    int randomNumber = RandomNumberUtil.generate(RANDOM_NUMBER_BOUND);
    if (randomNumber >= MEET_CONDITION_FOR_MOVEMENT) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }
}
