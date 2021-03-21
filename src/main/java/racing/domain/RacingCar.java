package racing.domain;

import racing.base.BaseCloneable;
import racing.rule.MoveRule;
import racing.validation.DomainValidation.RacingCarValid;

import java.util.Objects;

public class RacingCar implements BaseCloneable {

  private final String name;
  private int position;

  private RacingCar(String name) {
    this(name, 0);
  }

  private RacingCar(String name, int position) {
    this.name = name;
    this.position = position;
    RacingCarValid.check(this);
  }

  public static RacingCar create(String name) {
    return new RacingCar(name);
  }

  public String name() {
    return this.name;
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
    return String.format("name:%s, position:%d", name, position);
  }

  @Override
  public RacingCar clone() {
    try {
      return (RacingCar) super.clone();
    } catch (CloneNotSupportedException e) {
      return new RacingCar(null);
    }
  }
}
