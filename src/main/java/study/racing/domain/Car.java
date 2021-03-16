package study.racing.domain;

import java.util.Objects;

public class Car {

  private String name;
  private int position = 0;

  public Car() { }

  public Car(String name) {
    this.name = name;
  }

  public Car(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void move(MoveStrategy strategy) {
    if (strategy.isMove()) {
      this.position ++;
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
    return position == car.position && Objects.equals(name, car.name);
  }

}
