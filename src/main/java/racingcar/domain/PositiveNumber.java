package racingcar.domain;

import java.util.Objects;

public class PositiveNumber {
  private int value;

  public PositiveNumber(final int value) {
    this.value = value;
  }

  public void increaseConditionally(boolean meet) {
    if (meet) {
      this.value++;
    }
  }

  public boolean largerThan(PositiveNumber target) {
    return this.value > target.value;
  }

  public boolean largerThan(int target) {
    return this.largerThan(new PositiveNumber(target));
  }

  public boolean smallerThan(PositiveNumber target) {
    return this.value < target.value;
  }
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof PositiveNumber) {
      return this.value == ((PositiveNumber) obj).value;
    }

    if (obj instanceof Integer) {
      return this.value == ((Integer) obj);
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }

  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
