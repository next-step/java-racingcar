package racingcar.domain;

import java.util.Objects;

public class CarName {
  private String name;
  private static final int LENGTH_LIMIT = 5;

  public CarName(String name) {
    validateSize(name);
    this.name = name;
  }

  private void validateSize(String name) {
    if (name.length() > LENGTH_LIMIT) {
      throw new IllegalArgumentException(String.format("Car name longer than %d not allowed.", LENGTH_LIMIT));
    }
  }

  @Override
  public String toString() {
    return this.name;
  }

  @Override
  public boolean equals(Object target) {
    if (target instanceof CarName) {
      return this.name.equals(((CarName) target).name);
    }

    if (target instanceof String) {
      return this.name.equals(target);
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}