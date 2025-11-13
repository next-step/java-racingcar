package racing.domain;

import java.util.Objects;
import racing.exception.RacingException;

/**
 * 자동차 1. 전진 & 멈추기 2. 현재 위치 반환
 *
 */
public class Car {
  private static final int MOVE_BORDER = 4;
  private CarName name;
  private int position;

  public Car(String name){
    this(new CarName(name));
  }

  public Car(CarName name){
    this(name, 0);
  }

  public Car(CarName name, int position) {
    this.name = name;
    this.position = position;
  }

  public void move(int value) {
    if (value < MOVE_BORDER) {
      return;
    }
    this.position += 1;
  }

  public int getPosition() {
    return this.position;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(name, car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }

  public String getName() {
    return this.name.getName();
  }
}
