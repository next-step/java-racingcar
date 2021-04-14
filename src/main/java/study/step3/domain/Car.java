package study.step3.domain;

import java.util.Objects;

public class Car {

  private static final int MOVE_CONDITION_NUM = 4;

  private int position;

  public Car() { }

  public Car(int position) {
    this.position = position;
  }

  public int curPosition() {
    return position;
  }

  public void move(int conditionNumber) {
    if (isMovable(conditionNumber)) {
      this.position +=  + 1;
    }
  }

  public boolean isMovable(int conditionNumber) {
    return conditionNumber >= MOVE_CONDITION_NUM;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return position == car.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }

}
