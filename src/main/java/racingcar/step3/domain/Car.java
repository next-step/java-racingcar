package racingcar.step3.domain;

import java.util.UUID;

public class Car {

  public static final int DEFAULT_MOVE_COUNT = 0;
  public static final int MEET_CONDITION_FOR_MOVEMENT = 4;

  private final UUID id = UUID.randomUUID();
  private final String carName;
  private int moveCount;

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

  public void move(int randomNumber) {
    if (isSatisfied(randomNumber)) {
      this.moveCount += 1;
    }
  }

  private boolean isSatisfied(int randomNumber) {
    if (randomNumber >= MEET_CONDITION_FOR_MOVEMENT) {
      return Boolean.TRUE;
    }

    return Boolean.FALSE;
  }
}
