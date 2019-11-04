package step3.racingcarWinner;

import java.util.Objects;

public class Car {

  private String name;
  private int position;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return position == car.position &&
        Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }

  public void move() {
    this.position++;
  }
}
