package study.step3.domain;

import java.util.Objects;

public class Car {

  private MovableStrategy movableStrategy;

  private int position;

  public Car() {
  }

  public Car(int position) {
    this.position = position;
  }

  public Car(MovableStrategy movableStrategy) {
    this.movableStrategy = movableStrategy;
  }

  public int curPosition() {
    return position;
  }

  public void move() {
    int conditionNumber = movableStrategy.generateMoveNUmber();

    if (movableStrategy.isMovable(conditionNumber)) {
      this.position += 1;
    }
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
