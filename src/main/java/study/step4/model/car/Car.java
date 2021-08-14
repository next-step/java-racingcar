package study.step4.model.car;

import study.step4.exception.CarGameArgumentException;
import study.step4.model.strategy.MoveStrategy;

public class Car implements Comparable<Car> {

  private static final int CAR_NAME_MAX_LENGTH = 5;

  private int distance;
  private String name;

  public Car() {
  }

  public Car(String carName) {
    this(carName, 0);
  }

  public Car(String carName, int distance) {
    validateCarName(carName);

    this.name = carName;
    this.distance = distance;
  }

  private void validateCarName(String carName) {
    if (carName.length() > CAR_NAME_MAX_LENGTH) {
      throw new CarGameArgumentException("자동차 이름은 " + CAR_NAME_MAX_LENGTH + "자를 넘을 수 없습니다.");
    }
  }

  public int getDistance() {
    return distance;
  }

  public String getName() {
    return name;
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMoveCondition()) {
      distance++;
    }
  }

  @Override
  public int compareTo(Car other) {
    return Integer.compare(this.distance, other.distance);
  }
}
