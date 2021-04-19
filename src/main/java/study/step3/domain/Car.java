package study.step3.domain;

import java.util.Objects;

public class Car {

  private MovableStrategy movableStrategy;

  private int position;

  private String name;

  public Car() {
  }

  public Car(int position) {
    this.position = position;
  }

  public Car(int position, String name) {
    this.position = position;
    this.name = name;
  }

  public Car(MovableStrategy movableStrategy, String name) {
    this.movableStrategy = movableStrategy;
    this.name = name;
  }

  public int curPosition() {
    return position;
  }

  public String name() {
    return name;
  }

  public void move() {
    if (movableStrategy.isMovable()) {
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
