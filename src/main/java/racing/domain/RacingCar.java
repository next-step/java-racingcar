package racing.domain;

import racing.base.BaseCloneable;
import racing.rule.MoveRule;
import racing.utils.StringUtils;

import java.util.Objects;

public class RacingCar implements BaseCloneable {

  public final static int RACING_CAR_NAME_LENGTH = 5;
  private final String name;
  private int position;

  private RacingCar(String name) {
    this(name, 0);
  }

  private RacingCar(String name, int position) {
    this.name = name;
    this.position = position;
  }

  public static RacingCar create(String name) {
    checkNameLength(name);
    return new RacingCar(name);
  }

  private static void checkNameLength(String name) {
    boolean isBlankName = StringUtils.isBlank(name);
    if (isBlankName) {
      throw new IllegalArgumentException("Car name is not blank");
    }

    boolean validStringLength = name.length() <= RACING_CAR_NAME_LENGTH;
    if (!validStringLength) {
      throw new IllegalArgumentException("Car name length is exceed");
    }
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
