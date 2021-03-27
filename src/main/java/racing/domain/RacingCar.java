package racing.domain;

import racing.base.BaseCloneable;
import racing.rule.MoveRule;

import java.util.Objects;

public class RacingCar implements BaseCloneable {

  private final Name name;
  private Position position;

  private RacingCar(String name) {
    this(name, 0);
  }

  private RacingCar(String name, int position) {
    this.name = Name.create(name);
    this.position = Position.create(position);
  }

  public static RacingCar create(String name) {
    return new RacingCar(name);
  }

  public Name name() {
    return this.name;
  }

  public Position position() {
    return position;
  }

  public void move(MoveRule moveRule) {
    if (moveRule.possibleMove()) {
      position = position.move();
    }
  }

  public boolean isWinner(Position winnerPosition) {
    return position.isWinner(winnerPosition);
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
    return String.format("name:%s, position:%s", name, position);
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
