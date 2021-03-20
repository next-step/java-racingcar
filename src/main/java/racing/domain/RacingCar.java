package racing.domain;

import racing.base.BaseCloneable;
import racing.rule.MoveRule;

import java.util.Objects;

public class RacingCar implements BaseCloneable {

  private String name;
  private int carNumber;
  private int position;

  private RacingCar() { }

  private RacingCar(String name, int carNumber) {
    this(name, carNumber, 0);
  }

  private RacingCar(String name, int carNumber, int position) {
    this.name = name;
    this.carNumber = carNumber;
    this.position = position;
  }

  public static RacingCar create(String name) {
    return create(name, 0);
  }

  public static RacingCar create(int carNumber) {
    return create(null, carNumber);
  }

  public static RacingCar create(String name, int carNumber) {
    return new RacingCar(name, carNumber);
  }

  public String name() {
    return this.name;
  }

  public int carNumber() {
    return this.carNumber;
  }

  public int position() {
    return position;
  }

  public void move(MoveRule moveRule) {
    if (moveRule.possibleMove()) {
      this.position++;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    RacingCar racingCar = (RacingCar) o;
    return Objects.equals(name, racingCar.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return String.format("name:%s, carNumber:%d, position:%s", name, carNumber, position);
  }

  @Override
  public RacingCar clone() {
    try {
      return (RacingCar) super.clone();
    } catch (CloneNotSupportedException e) {
      return new RacingCar();
    }
  }
}
